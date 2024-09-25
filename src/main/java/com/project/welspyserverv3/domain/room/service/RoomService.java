package com.project.welspyserverv3.domain.room.service;

import com.project.welspyserverv3.domain.room.client.dto.MemberList;
import com.project.welspyserverv3.domain.room.client.dto.Room;
import com.project.welspyserverv3.domain.room.client.dto.request.RoomCreateRequest;
import com.project.welspyserverv3.domain.room.client.dto.request.RoomJoinRequest;
import com.project.welspyserverv3.domain.room.domain.entity.MemberListEntity;
import com.project.welspyserverv3.domain.room.domain.entity.RoomEntity;
import com.project.welspyserverv3.domain.room.domain.repository.jpa.MemberListJpaRepository;
import com.project.welspyserverv3.domain.room.domain.repository.jpa.RoomJpaRepository;
import com.project.welspyserverv3.domain.room.exception.MemberLimitOverException;
import com.project.welspyserverv3.domain.room.exception.RoomNotFoundException;
import com.project.welspyserverv3.global.common.repository.UserSecurity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoomService {

    private final RoomJpaRepository roomJpaRepository;
    private final MemberListJpaRepository memberListJpaRepository;
    private final UserSecurity userSecurity;
    private final Room roomDto;

    public void createRoom(RoomCreateRequest request) {
        saveRoom(Room.builder()
                .title(request.getTitle())
                .description(request.getDescription())
                .goalMoney(request.getGoalMoney())
                .memberLimit(request.getMemberLimit())
                .category(request.getCategory())
                .roomType(request.getRoomType())
                .build());
    }

    public void joinRoom(RoomJoinRequest request) {
        Room room = getRoomById(request.getRoomId());
        if(room.getMemberLimit() + 1 > room.getMemberLimit()){
            throw MemberLimitOverException.EXCEPTION;
        }
        saveMemberList(MemberList.builder()
                .roomId(room.getRoomId())
                .email(userSecurity.getUser().getEmail())
                .balance(0L)
                .build());
    }

    public void saveRoom(Room room){
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

    public void saveMemberList(MemberList memberList){
        memberListJpaRepository.save(MemberListEntity.builder()
                .idx(memberList.getIdx())
                .roomId(memberList.getRoomId())
                .email(memberList.getEmail())
                .build());
    }

    public Room getRoomById(Long roomId){
        return roomJpaRepository
                .findById(roomId)
                .map(roomDto::toRoom)
                .orElseThrow(()-> RoomNotFoundException.EXCEPTION);
    }

}
