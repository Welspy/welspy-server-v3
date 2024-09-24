package com.project.welspyserverv3.domain.bank.domain.entity;

import com.project.welspyserverv3.domain.bank.domain.enums.BankType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Getter
@SuperBuilder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "tb_bank_log")
public class BankLogEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @Column(nullable = false)
    private String accountNumber;

    @Column(nullable = false)
    private Long money;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private BankType bankType;

}
