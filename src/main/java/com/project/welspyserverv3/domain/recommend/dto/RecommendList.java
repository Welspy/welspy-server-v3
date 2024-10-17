package com.project.welspyserverv3.domain.recommend.dto;

import com.project.welspyserverv3.domain.room.domain.enums.Category;
import com.project.welspyserverv3.domain.room.domain.enums.RoomType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RecommendList {

    private Long roomId;
    private String title;
    private String description;
    private Long goalMoney;
    private int memberLimit;
    private int currentMember;
    private String imageUrl;
    private Category category;
    private RoomType roomType;
    private Long productId;

}
