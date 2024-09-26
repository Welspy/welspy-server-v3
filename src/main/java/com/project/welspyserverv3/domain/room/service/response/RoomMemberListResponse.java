package com.project.welspyserverv3.domain.room.service.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class RoomMemberListResponse {

    private Long idx;
    private Long roomId;
    private String email;
    private Long balance;
    private String name;

}
