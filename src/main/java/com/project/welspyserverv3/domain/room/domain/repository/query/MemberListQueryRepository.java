package com.project.welspyserverv3.domain.room.domain.repository.query;

import com.project.welspyserverv3.domain.room.client.dto.MemberList;
import com.project.welspyserverv3.domain.room.client.dto.request.RoomMemberListRequest;
import com.project.welspyserverv3.domain.room.service.response.RoomMemberListResponse;
import com.project.welspyserverv3.global.common.dto.request.PageRequest;
import com.querydsl.core.types.ConstructorExpression;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.project.welspyserverv3.domain.room.domain.entity.QMemberListEntity.memberListEntity;

@Repository
@RequiredArgsConstructor
public class MemberListQueryRepository {

    private final JPAQueryFactory jpaQueryFactory;

    public List<MemberList> myRoomList(PageRequest request, String email) {
        return jpaQueryFactory
                .select(memberListConstructorExpression())
                .from(memberListEntity)
                .where(memberListEntity.email.eq(email))
                .offset((long) (request.getPage() - 1) * request.getSize())
                .limit(request.getSize())
                .orderBy(memberListEntity.idx.desc())
                .fetch();
    }

    public List<RoomMemberListResponse> roomMemberList(RoomMemberListRequest request) {
        return jpaQueryFactory
                .select(roomMemberListConstructorExpression())
                .from(memberListEntity)
                .where(memberListEntity.roomId.eq(request.getRoomId()))
                .offset((long) (request.getPage() - 1) * request.getSize())
                .limit(request.getSize())
                .orderBy(memberListEntity.idx.desc())
                .fetch();
    }

    private ConstructorExpression<MemberList> memberListConstructorExpression(){
        return Projections.constructor(MemberList.class,
                memberListEntity.idx,
                memberListEntity.roomId,
                memberListEntity.email,
                memberListEntity.balance,
                memberListEntity.name,
                memberListEntity.title,
                memberListEntity.description,
                memberListEntity.goalMoney
        );
    }

    private ConstructorExpression<RoomMemberListResponse> roomMemberListConstructorExpression(){
        return Projections.constructor(RoomMemberListResponse.class,
                memberListEntity.idx,
                memberListEntity.roomId,
                memberListEntity.email,
                memberListEntity.balance,
                memberListEntity.name
        );
    }

}
