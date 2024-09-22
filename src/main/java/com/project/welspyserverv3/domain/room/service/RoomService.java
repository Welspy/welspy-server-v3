package com.project.welspyserverv3.domain.room.service;

import com.project.welspyserverv3.domain.room.client.dto.Room;
import com.project.welspyserverv3.domain.room.client.dto.request.RoomCreateRequest;
import com.project.welspyserverv3.domain.room.domain.entity.RoomEntity;
import com.project.welspyserverv3.domain.room.domain.repository.jpa.RoomJpaRepository;
import com.project.welspyserverv3.domain.room.exception.RoomNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoomService {

    private final RoomJpaRepository roomJpaRepository;
    private final Room roomDto;

    public void createRoom(RoomCreateRequest request) {
        save(Room.builder()
                .title(request.getTitle())
                .description(request.getDescription())
                .goalMoney(request.getGoalMoney())
                .memberLimit(request.getMemberLimit())
                .category(request.getCategory())
                .roomType(request.getRoomType())
                .build());
    }

    public void save(Room room){
        roomJpaRepository.save(RoomEntity.builder()
                .roomId(room.getRoomId())
                .title(room.getTitle())
                .description(room.getDescription())
                .goalMoney(room.getGoalMoney())
                .memberLimit(room.getMemberLimit())
                .category(room.getCategory())
                .roomType(room.getRoomType())
                .build()
        );
    }

    public Room getRoomById(Long roomId){
        return roomJpaRepository
                .findById(roomId)
                .map(roomDto::toRoom)
                .orElseThrow(()-> RoomNotFoundException.EXCEPTION);
    }

}
