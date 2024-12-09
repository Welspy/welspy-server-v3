package com.project.welspyserverv3.domain.user.service;

import com.project.welspyserverv3.domain.room.domain.entity.MemberListEntity;
import com.project.welspyserverv3.domain.room.domain.repository.jpa.MemberListJpaRepository;
import com.project.welspyserverv3.domain.user.client.dto.User;
import com.project.welspyserverv3.domain.user.domain.entity.UserEntity;
import com.project.welspyserverv3.domain.user.domain.repository.jpa.UserJpaRepository;
import com.project.welspyserverv3.domain.user.exception.UserNotFoundException;
import com.project.welspyserverv3.global.common.repository.UserSecurity;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserJpaRepository userJpaRepository;
    private final UserSecurity userSecurity;
    private final User userDTO;
    private final MemberListJpaRepository memberListJpaRepository;

    public User getUser() {
        return userJpaRepository
                .findByEmail(userSecurity.getUser().getEmail())
                .map(userDTO::toUser)
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);
    }

    public User getUserByEmail(String email) {
        return userJpaRepository
                .findByEmail(email)
                .map(userDTO::toUser)
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);
    }

    public void userDelete(){
        User user = getUser();
        userJpaRepository.deleteByEmail(user.getEmail());
        List<MemberListEntity> memberList = memberListJpaRepository
                .findAllByEmail(userSecurity.getUser().getEmail());

    }

    public void editUser(User requestUser) {
        User user = getUser();
        user.setEmail(requestUser.getEmail());
        user.setName(requestUser.getName());
        user.setPhoneNumber(requestUser.getPhoneNumber());
        userJpaRepository.save(UserEntity.builder()
                .email(user.getEmail())
                .name(user.getName())
                .password(user.getPassword())
                .phoneNumber(user.getPhoneNumber())
                .userRole(user.getUserRole())
                .build());
    }

}
