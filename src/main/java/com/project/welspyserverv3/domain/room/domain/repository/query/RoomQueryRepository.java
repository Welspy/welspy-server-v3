package com.project.welspyserverv3.domain.room.domain.repository.query;

import com.project.welspyserverv3.domain.room.client.dto.Room;
import com.project.welspyserverv3.domain.room.client.dto.request.RoomSearchRequest;
import com.project.welspyserverv3.global.common.dto.request.PageRequest;
import com.querydsl.core.types.ConstructorExpression;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.project.welspyserverv3.domain.room.domain.entity.QRoomEntity.roomEntity;

@Repository
@RequiredArgsConstructor
public class RoomQueryRepository {

    private final JPAQueryFactory jpaQueryFactory;

    public List<Room> roomList(PageRequest request){
        return jpaQueryFactory
                .select(roomConstructorExpression())
                .from(roomEntity)
                .offset((long) (request.getPage() - 1) * request.getSize())
                .limit(request.getSize())
                .orderBy(roomEntity.roomId.desc())
                .fetch();
    }

    public List<Room> roomSearch(RoomSearchRequest request){
        return jpaQueryFactory
                .select(roomConstructorExpression())
                .from(roomEntity)
                .where(roomEntity.title.contains(request.getTitle()))
                .offset((long) (request.getPage() - 1) * request.getSize())
                .limit(request.getSize())
                .orderBy(roomEntity.roomId.desc())
                .fetch();
    }

    private ConstructorExpression<Room> roomConstructorExpression(){
        return Projections.constructor(Room.class,
                roomEntity.roomId,
                roomEntity.title,
                roomEntity.description,
                roomEntity.goalMoney,
                roomEntity.memberLimit,
                roomEntity.category,
                roomEntity.roomType
        );
    }

}
