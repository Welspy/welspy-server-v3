package com.project.welspyserverv3.domain.recommend.service;

import com.project.welspyserverv3.domain.recommend.dto.RecommendList;
import com.project.welspyserverv3.domain.recommend.dto.RoomIdList;
import com.project.welspyserverv3.global.common.dto.request.PageRequest;
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

    private static final String URL="http://34.64.219.190:8000";

//    public ResponseEntity<List<RecommendList>> recommendList(){
//
//    }

    public RoomIdList getRoomIdList(PageRequest request, String email){
        URI uri = UriComponentsBuilder
                .fromUriString(URL)
                .path("/recommendations")
                .queryParam(
                        "page", request.getPage(),
                        "size", request.getSize(),
                        "email", email
                )
                .encode()
                .build()
                .toUri();
        ResponseEntity<RoomIdList> responseEntity = restTemplate.getForEntity(uri, RoomIdList.class);
        if(responseEntity.getBody() == null){
            throw new NullPointerException();
        }
        return RoomIdList.builder()
                .roomIdList(responseEntity.getBody().getRoomIdList())
                .build();
    }

}
