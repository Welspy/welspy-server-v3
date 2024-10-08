package com.project.welspyserverv3.domain.room.client.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MemberList {

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
