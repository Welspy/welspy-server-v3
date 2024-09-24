package com.project.welspyserverv3.domain.room.service;

import com.project.welspyserverv3.domain.room.client.dto.Room;
import com.project.welspyserverv3.domain.room.client.dto.request.RoomSearchRequest;
import com.project.welspyserverv3.domain.room.domain.repository.query.RoomQueryRepository;
import com.project.welspyserverv3.global.common.dto.request.PageRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoomQueryService {

    private final RoomQueryRepository roomQueryRepository;

    public List<Room> roomList(PageRequest request){
        return roomQueryRepository.roomList(request);
    }

    public List<Room> roomSearch(RoomSearchRequest request){
        return roomQueryRepository.roomSearch(request);
    }

    public List<Room> privateRoom(PageRequest request){
        return roomQueryRepository.privateRoom(request);
    }

    public List<Room> publicRoom(PageRequest request){
        return roomQueryRepository.publicRoom(request);
    }

}
