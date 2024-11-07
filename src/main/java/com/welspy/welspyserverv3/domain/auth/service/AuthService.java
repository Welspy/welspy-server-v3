package com.welspy.welspyserverv3.domain.auth.service;

import com.welspy.welspyserverv3.domain.auth.client.dto.request.SignInRequest;
import com.welspy.welspyserverv3.domain.auth.client.dto.request.SignUpRequest;
import com.welspy.welspyserverv3.domain.auth.service.response.JsonWebTokenResponse;
import com.welspy.welspyserverv3.domain.auth.service.response.RefreshTokenResponse;
import com.welspy.welspyserverv3.domain.auth.service.response.SignUpResponse;
import com.welspy.welspyserverv3.domain.bank.service.BankService;
import com.welspy.welspyserverv3.domain.user.domain.entity.UserEntity;
import com.welspy.welspyserverv3.domain.user.domain.enums.UserRole;
import com.welspy.welspyserverv3.domain.user.domain.repository.jpa.UserJpaRepository;
import com.welspy.welspyserverv3.domain.user.exception.PasswordWrongException;
import com.welspy.welspyserverv3.domain.user.exception.UserExistException;
import com.welspy.welspyserverv3.domain.user.exception.UserNotFoundException;
import com.welspy.welspyserverv3.global.security.jwt.JwtProvider;
import com.welspy.welspyserverv3.global.security.jwt.enums.JwtType;
import com.welspy.welspyserverv3.global.security.jwt.exception.TokenTypeException;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserJpaRepository userJpaRepository;
    private final BankService bankService;
    private final PasswordEncoder encoder;
    private final JwtProvider jwtProvider;

    public SignUpResponse signUp(SignUpRequest request) {
        if (checkUserByEmail(request.email())){
            throw UserExistException.EXCEPTION;
        }
        userJpaRepository.save(UserEntity.builder()
                .email(request.email())
                .name(request.name())
                .phoneNumber(request.phoneNumber())
                .password(encoder.encode(request.password()))
                .imageUrl(request.imageUrl())
                .userRole(UserRole.USER)
                .build()
        );
        return SignUpResponse.builder()
                .accountNumber(bankService.createAccount(request.email()))
                .build();
    }

    public JsonWebTokenResponse signIn(SignInRequest request) {
        if(!checkUserByEmail(request.email())){
            throw UserNotFoundException.EXCEPTION;
        }
        String userPassword = userJpaRepository.getByEmail(request.email()).getPassword();
        if (!encoder.matches(request.password(), userPassword))
            throw PasswordWrongException.EXCEPTION;
        return JsonWebTokenResponse.builder()
                .accessToken(jwtProvider.generateAccessToken(request.email(), UserRole.USER))
                .refreshToken(jwtProvider.generateRefreshToken(request.email(), UserRole.USER))
                .build();
    }

    public RefreshTokenResponse refresh(String token) {
        Jws<Claims> claims = jwtProvider.getClaims(jwtProvider.extractToken(token));
        if (jwtProvider.isWrongType(claims, JwtType.REFRESH)) {
            throw TokenTypeException.EXCEPTION;
        }
        return RefreshTokenResponse.builder()
                .accessToken(jwtProvider.generateAccessToken(claims.getBody().getSubject(),
                        (UserRole) claims.getHeader().get("authority"))).build();
    }

    public boolean checkUserByEmail(String email) {
        // 유저가 존재한다면 true, 없다면 false
        return userJpaRepository.findByEmail(email).isPresent();
    }

}
