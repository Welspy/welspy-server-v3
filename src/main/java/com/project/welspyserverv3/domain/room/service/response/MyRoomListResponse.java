package com.project.welspyserverv3.domain.room.service.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class MyRoomListResponse {

    private Long idx;
    private Long roomId;
    private String email;
    private Long balance;
    private String name;
    private String title;
    private String description;
    private Long goalMoney;
    private String imageUrl;

}
