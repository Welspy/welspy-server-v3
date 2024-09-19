package com.project.welspyserverv3.domain.user.usecase;

import com.project.welspyserverv3.domain.user.client.dto.User;
import com.project.welspyserverv3.domain.user.client.dto.request.EmailEditRequest;
import com.project.welspyserverv3.domain.user.client.dto.request.NameEditRequest;
import com.project.welspyserverv3.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserUseCase {

    public final UserService userService;

    public User getUser(){
        return userService.getUser();
    }

    public void editName(NameEditRequest request){
        User user = userService.getUser();
        user.setName(request.getName());
        userService.save(user);
    }

    public void editEmail(EmailEditRequest request) {
        User user = userService.getUser();
        user.setEmail(request.getEmail());
        userService.save(user);
    }

}
