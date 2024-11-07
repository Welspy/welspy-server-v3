package com.project.welspyserverv3.domain.room.domain.mapper;

import com.project.welspyserverv3.domain.room.client.dto.MemberList;
import com.project.welspyserverv3.domain.room.domain.entity.MemberListEntity;
import org.springframework.stereotype.Component;

@Component
public class MemberListMapper {

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
                .build();
    }

}
