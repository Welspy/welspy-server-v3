package com.project.welspyserverv3.domain.room.client.dto.request;

import com.project.welspyserverv3.global.common.dto.request.PageRequest;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RoomMemberListRequest extends PageRequest {

    private Long roomId;

}
