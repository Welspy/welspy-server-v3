package com.project.welspyserverv3.domain.room.client.dto;

import com.project.welspyserverv3.domain.room.domain.entity.RoomEntity;
import com.project.welspyserverv3.domain.room.domain.enums.Category;
import com.project.welspyserverv3.domain.room.domain.enums.RoomType;
import com.project.welspyserverv3.domain.user.client.dto.User;
import com.project.welspyserverv3.domain.user.domain.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Builder
@Component
@AllArgsConstructor
@NoArgsConstructor
public class Room {

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
    private String productImageUrl;

    public Room(Long roomId, String title, String description, Long goalMoney, int memberLimit, String imageUrl, Category category, RoomType roomType, Long productId, String productImageUrl) {
        this.roomId = roomId;
        this.title = title;
        this.description = description;
        this.goalMoney = goalMoney;
        this.memberLimit = memberLimit;
        this.imageUrl = imageUrl;
        this.category = category;
        this.roomType = roomType;
        this.productId = productId;
        this.productImageUrl = productImageUrl;
    }

    public Room toRoom(RoomEntity roomEntity) {
        return Room.builder()
                .roomId(roomEntity.getRoomId())
                .title(roomEntity.getTitle())
                .description(roomEntity.getDescription())
                .goalMoney(roomEntity.getGoalMoney())
                .memberLimit(roomEntity.getMemberLimit())
                .currentMember(roomEntity.getCurrentMember())
                .imageUrl(roomEntity.getImageUrl())
                .category(roomEntity.getCategory())
                .roomType(roomEntity.getRoomType())
                .productId(roomEntity.getProductId())
                .productImageUrl(roomEntity.getProductImageUrl())
                .build();
    }

}
