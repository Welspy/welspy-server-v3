package com.project.welspyserverv3.domain.room.service;

import com.project.welspyserverv3.domain.room.client.dto.MemberList;
import com.project.welspyserverv3.domain.room.client.dto.Room;
import com.project.welspyserverv3.domain.room.client.dto.request.RoomMemberListRequest;
import com.project.welspyserverv3.domain.room.client.dto.request.RoomSearchRequest;
import com.project.welspyserverv3.domain.room.domain.repository.query.MemberListQueryRepository;
import com.project.welspyserverv3.domain.room.domain.repository.query.RoomQueryRepository;
import com.project.welspyserverv3.global.common.dto.request.PageRequest;
import com.project.welspyserverv3.global.common.repository.UserSecurity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoomQueryService {

    private final RoomQueryRepository roomQueryRepository;
    private final MemberListQueryRepository memberListQueryRepository;
    private final UserSecurity userSecurity;

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

    public List<MemberList> myRoomList(PageRequest request){
        return memberListQueryRepository.myRoomList(request, userSecurity.getUser().getEmail());
    }

    public List<MemberList> roomMemberList (RoomMemberListRequest request){
        return memberListQueryRepository.roomMemberList(request);
    }

}
