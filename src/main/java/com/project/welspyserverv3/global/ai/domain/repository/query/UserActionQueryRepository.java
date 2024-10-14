package com.project.welspyserverv3.global.ai.domain.repository.query;

import com.project.welspyserverv3.global.ai.client.dto.DataResponse;
import com.querydsl.core.types.ConstructorExpression;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.project.welspyserverv3.global.ai.domain.entity.QUserAction.userAction;

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

    private ConstructorExpression<DataResponse> userActionConstructorExpression(){
        return Projections.constructor(DataResponse.class,
                userAction.id,
                userAction.challengeId,
                userAction.userEmail,
                userAction.category,
                userAction.startTime
        );
    }

}
