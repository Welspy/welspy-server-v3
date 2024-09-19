package com.project.welspyserverv3.domain.user.client.dto;

import com.project.welspyserverv3.domain.user.domain.entity.UserEntity;
import com.project.welspyserverv3.domain.user.domain.enums.UserRole;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Builder
@Component
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private String email;
    private String name;
    private String phoneNumber;
    private String password;
    private UserRole userRole;

    public User toUser(UserEntity userEntity){
        return User.builder()
                .email(userEntity.getEmail())
                .name(userEntity.getName())
                .phoneNumber(userEntity.getPhoneNumber())
                .password(userEntity.getPassword())
                .userRole(userEntity.getUserRole())
                .build();
    }

    public UserEntity toUserEntity(User user){
        return UserEntity.builder()
                .email(user.email)
                .name(user.name)
                .phoneNumber(user.phoneNumber)
                .password(user.password)
                .userRole(user.userRole)
                .build();
    }

}
