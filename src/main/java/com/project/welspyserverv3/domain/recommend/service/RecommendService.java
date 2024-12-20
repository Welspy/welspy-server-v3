package com.project.welspyserverv3.domain.recommend.service;

import com.project.welspyserverv3.domain.recommend.client.dto.RoomIdsResponse;
import com.project.welspyserverv3.domain.room.client.dto.Room;
import com.project.welspyserverv3.domain.room.domain.entity.RoomEntity;
import com.project.welspyserverv3.domain.room.domain.repository.jpa.RoomJpaRepository;
import com.project.welspyserverv3.global.common.dto.request.PageRequest;
import com.project.welspyserverv3.global.common.repository.UserSecurity;
import java.net.URI;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import org.webjars.NotFoundException;

@Service
@RequiredArgsConstructor
public class RecommendService {

    private final RestTemplate restTemplate;
    private final UserSecurity userSecurity;
    private final RoomJpaRepository roomJpaRepository;

    @Value("${fast-api.url}")
    private String url;

    public List<Room> recommendList(PageRequest request) {
        List<Long> roomIds = getRoomIdList(request);
        List<RoomEntity> roomEntities = roomJpaRepository.findRoomEntitiesByRoomIdIn(roomIds);
        return roomEntities.stream()
                .map(Room::new)
                .toList();
    }

    public List<Long> getRoomIdList(PageRequest request) {
        URI uri = UriComponentsBuilder
                .fromUriString(url)
                .path("/recommendations")
                .queryParam("user_email", userSecurity.getUser().getEmail())
                .queryParam("page", request.getPage())
                .queryParam("size", request.getSize())
                .encode()
                .build()
                .toUri();
        ResponseEntity<RoomIdsResponse> responseEntity = restTemplate.getForEntity(uri, RoomIdsResponse.class);
        if (responseEntity.getBody() == null || responseEntity.getBody().getRoomIds() == null) {
            throw new NotFoundException("응답값을 찾을 수 없습니다.");
        }
        List<Long> roomIds = responseEntity.getBody().getRoomIds();
        return roomIds;
    }

}