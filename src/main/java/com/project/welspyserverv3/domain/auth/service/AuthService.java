package com.project.welspyserverv3.domain.auth.service;

import com.project.welspyserverv3.domain.auth.client.dto.request.SignInRequest;
import com.project.welspyserverv3.domain.auth.client.dto.request.SignUpRequest;
import com.project.welspyserverv3.domain.auth.service.response.JsonWebTokenResponse;
import com.project.welspyserverv3.domain.auth.service.response.RefreshTokenResponse;
import com.project.welspyserverv3.domain.user.client.dto.User;
import com.project.welspyserverv3.domain.user.domain.enums.UserRole;
import com.project.welspyserverv3.domain.user.domain.repository.jpa.UserJpaRepository;
import com.project.welspyserverv3.domain.user.exception.PasswordWrongException;
import com.project.welspyserverv3.domain.user.exception.UserExistException;
import com.project.welspyserverv3.domain.user.exception.UserNotFoundException;
import com.project.welspyserverv3.global.security.jwt.JwtProvider;
import com.project.welspyserverv3.global.security.jwt.enums.JwtType;
import com.project.welspyserverv3.global.security.jwt.exception.TokenTypeException;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserJpaRepository userJpaRepository;
    private final User userDTO;
    private final PasswordEncoder encoder;
    private final JwtProvider jwtProvider;
    public void signUp(SignUpRequest request) {
        if (checkUserByEmail(request.getEmail())){
            throw UserExistException.EXCEPTION;
        }
        userJpaRepository.save(userDTO.toUserEntity(
                User.builder()
                        .email(request.getEmail())
                        .name(request.getName())
                        .phoneNumber(request.getPhoneNumber())
                        .password(encoder.encode(request.getPassword()))
                        .userRole(UserRole.USER)
                        .build()
        ));
    }

    public JsonWebTokenResponse signIn(SignInRequest request) {
        if(!checkUserByEmail(request.getEmail())){
            throw UserNotFoundException.EXCEPTION;
        }
        String userPassword = userJpaRepository.getByEmail(request.getEmail()).getPassword();
        if (!encoder.matches(request.getPassword(), userPassword))
            throw PasswordWrongException.EXCEPTION;
        return JsonWebTokenResponse.builder()
                .accessToken(jwtProvider.generateAccessToken(request.getEmail(), UserRole.USER))
                .refreshToken(jwtProvider.generateRefreshToken(request.getEmail(), UserRole.USER))
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
