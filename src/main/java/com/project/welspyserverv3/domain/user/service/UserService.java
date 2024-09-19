package com.project.welspyserverv3.domain.user.service;

import com.project.welspyserverv3.domain.user.client.dto.User;
import com.project.welspyserverv3.domain.user.domain.repository.jpa.UserJpaRepository;
import com.project.welspyserverv3.domain.user.exception.UserNotFoundException;
import com.project.welspyserverv3.global.common.repository.UserSecurity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserJpaRepository userJpaRepository;
    private final UserSecurity userSecurity;
    private final User userDTO;

    public User getUser() {
        return userJpaRepository
                .findByEmail(userSecurity.getUser().getEmail())
                .map(userDTO::toUser)
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);
    }

    public void save(User user) {
        userJpaRepository.save(userDTO.toUserEntity(user));
    }

}
