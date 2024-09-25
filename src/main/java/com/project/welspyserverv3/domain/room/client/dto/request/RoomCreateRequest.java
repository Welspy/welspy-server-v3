package com.project.welspyserverv3.domain.room.client.dto.request;

import com.project.welspyserverv3.domain.room.domain.enums.Category;
import com.project.welspyserverv3.domain.room.domain.enums.RoomType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RoomCreateRequest {

    private String title;
    private String description;
    private Long goalMoney;
    private int memberLimit;
    private String imageUrl;
    private Category category;
    private RoomType roomType;
    private Long productId;
    private String productImageUrl;

}
