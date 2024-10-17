package com.project.welspyserverv3.domain.recommend.service;

import com.project.welspyserverv3.domain.recommend.client.dto.RoomIdsResponse;
import com.project.welspyserverv3.global.common.dto.request.PageRequest;
import com.project.welspyserverv3.global.common.repository.UserSecurity;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RecommendService {

    private final RestTemplate restTemplate;
    private final UserSecurity userSecurity;

    private static final String URL="http://34.64.219.190:8000";

//    public ResponseEntity<List<RecommendList>> recommendList(){
//
//    }

    public List<Long> getRoomIdList(PageRequest request) {
        URI uri = UriComponentsBuilder
                .fromUriString(URL)
                .path("/recommendations")
                .queryParam(
                        "user_email", userSecurity.getUser().getEmail(),
                        "page", request.getPage(),
                        "size", request.getSize()
                )
                .encode()
                .build()
                .toUri();

        // 서버 응답을 RoomIdsResponse로 받음
        ResponseEntity<RoomIdsResponse> responseEntity = restTemplate.getForEntity(uri, RoomIdsResponse.class);

        // 응답 확인 후 처리
        if (responseEntity.getBody() == null || responseEntity.getBody().getRoomIds() == null) {
            System.out.println("널인데용");
            throw new NullPointerException("널");
        }

        List<Long> roomIds = responseEntity.getBody().getRoomIds();
        System.out.println(roomIds.toString());
        return roomIds;
    }


}
