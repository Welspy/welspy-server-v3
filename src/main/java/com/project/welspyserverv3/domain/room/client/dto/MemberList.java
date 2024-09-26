package com.project.welspyserverv3.domain.room.client.dto;

import com.project.welspyserverv3.domain.room.domain.entity.MemberListEntity;
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
public class MemberList {

    private Long idx;
    private Long roomId;
    private String email;
    private Long balance;
    private String name;
    private String title;
    private String description;
    private Long goalMoney;
    private String productImageUrl;

    public MemberList(Long balance, String description, String email, Long goalMoney, Long idx, String name, String productImageUrl, Long roomId, String title) {
        this.balance = balance;
        this.description = description;
        this.email = email;
        this.goalMoney = goalMoney;
        this.idx = idx;
        this.name = name;
        this.productImageUrl = productImageUrl;
        this.roomId = roomId;
        this.title = title;
    }

    public MemberList toMemberList(MemberListEntity memberListEntity) {
        return MemberList.builder()
                .idx(memberListEntity.getIdx())
                .roomId(memberListEntity.getRoomId())
                .email(memberListEntity.getEmail())
                .balance(memberListEntity.getBalance())
                .name(memberListEntity.getName())
                .title(memberListEntity.getTitle())
                .description(memberListEntity.getDescription())
                .goalMoney(memberListEntity.getGoalMoney())
                .productImageUrl(memberListEntity.getProductImageUrl())
                .build();
    }

}
