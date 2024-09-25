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

    public MemberList toMemberList(MemberListEntity memberListEntity) {
        return MemberList.builder()
                .idx(memberListEntity.getIdx())
                .roomId(memberListEntity.getRoomId())
                .email(memberListEntity.getEmail())
                .balance(memberListEntity.getBalance())
                .build();
    }

}
