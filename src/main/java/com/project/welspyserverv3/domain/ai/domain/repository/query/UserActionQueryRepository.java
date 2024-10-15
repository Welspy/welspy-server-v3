package com.project.welspyserverv3.domain.ai.domain.repository.query;

import com.project.welspyserverv3.domain.ai.client.dto.DataResponse;
import com.project.welspyserverv3.domain.ai.client.dto.RoomIdResponse;
import com.querydsl.core.types.ConstructorExpression;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.project.welspyserverv3.domain.ai.domain.entity.QUserAction.userAction;
import static com.project.welspyserverv3.domain.room.domain.entity.QRoomEntity.roomEntity;

@Repository
@RequiredArgsConstructor
public class UserActionQueryRepository {

    private final JPAQueryFactory jpaQueryFactory;

    public List<DataResponse> getAllUserActions() {
        return jpaQueryFactory
                .select(userActionConstructorExpression())
                .from(userAction)
                .orderBy(userAction.id.asc())
                .fetch();
    }

    public List<RoomIdResponse> getAllRoomId() {
        return jpaQueryFactory
                .select(roomIdConstructorExpression())
                .from(roomEntity)
                .orderBy(roomEntity.roomId.asc())
                .fetch();
    }

    private ConstructorExpression<DataResponse> userActionConstructorExpression(){
        return Projections.constructor(DataResponse.class,
                userAction.id,
                userAction.challengeId,
                userAction.userEmail,
                userAction.category,
                userAction.startTime
        );
    }

    private ConstructorExpression<RoomIdResponse> roomIdConstructorExpression(){
        return Projections.constructor(RoomIdResponse.class,
                roomEntity.roomId
                );
    }

}
