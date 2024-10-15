package com.project.welspyserverv3.domain.ai.service;

import com.project.welspyserverv3.domain.ai.client.dto.DataResponse;
import com.project.welspyserverv3.domain.ai.client.dto.RoomIdResponse;
import com.project.welspyserverv3.domain.ai.domain.repository.query.UserActionQueryRepository;
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

    public List<RoomIdResponse> getAllRoomId(){
        return userActionQueryRepository.getAllRoomId();
    }

}