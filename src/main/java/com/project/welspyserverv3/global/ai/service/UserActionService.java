package com.project.welspyserverv3.global.ai.service;

import com.project.welspyserverv3.global.ai.client.dto.DataResponse;
import com.project.welspyserverv3.global.ai.domain.repository.query.UserActionQueryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserActionService {

    private final UserActionQueryRepository userActionQueryRepository;

    public List<DataResponse> getAllUserActions() {
        return userActionQueryRepository.getAllUserActions();
    }

}
