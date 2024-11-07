package com.welspy.welspyserverv3.global.common.repository;

import com.welspy.welspyserverv3.domain.user.client.dto.User;
import com.welspy.welspyserverv3.global.security.auth.CustomUserDetails;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;

@Repository
public class UserSecurityImpl implements UserSecurity{

    @Override
    public User getUser() {
        return ((CustomUserDetails) SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getPrincipal())
                .getUser();
    }

}
