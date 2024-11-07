package com.project.welspyserverv3.domain.bank.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
@Table(name = "tb_bank")
public class BankEntity {

    @Id
    @Column(unique = true, nullable = false)
    private String accountNumber;

    @Column
    private Long balance;

    @Column(nullable = false, unique = true)
    private String email;

}
