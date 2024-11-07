package com.project.welspyserverv3.domain.bank.domain.repository.query;

import com.project.welspyserverv3.domain.bank.client.dto.BankLog;
import com.project.welspyserverv3.global.common.dto.request.PageRequest;
import com.querydsl.core.types.ConstructorExpression;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.project.welspyserverv3.domain.bank.domain.entity.QBankLogEntity.bankLogEntity;

@Repository
@RequiredArgsConstructor
public class BankLogQueryRepository {

    private final JPAQueryFactory jpaQueryFactory;

    public List<BankLog> getAllLog(PageRequest request) {
        return jpaQueryFactory
                .select(bankLogConstructorExpression())
                .from(bankLogEntity)
                .offset((long) (request.getPage() - 1) * request.getSize())
                .limit(request.getSize())
                .orderBy(bankLogEntity.idx.desc())
                .fetch();
    }

    public List<BankLog> getMyLog(PageRequest request, String accountNumber) {
        return jpaQueryFactory
                .select(bankLogConstructorExpression())
                .from(bankLogEntity)
                .where(bankLogEntity.accountNumber.eq(accountNumber))
                .offset((long) (request.getPage() - 1) * request.getSize())
                .limit(request.getSize())
                .orderBy(bankLogEntity.idx.desc())
                .fetch();
    }

    private ConstructorExpression<BankLog> bankLogConstructorExpression(){
        return Projections.constructor(BankLog.class,
                bankLogEntity.idx,
                bankLogEntity.accountNumber,
                bankLogEntity.money,
                bankLogEntity.bankType,
                bankLogEntity.logDateTime
        );
    }

}