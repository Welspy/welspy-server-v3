package com.project.welspyserverv3.domain.bank.domain.repository;

import com.project.welspyserverv3.domain.bank.domain.entity.BankEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BankJpaRepository extends JpaRepository<BankEntity, String>{
    Optional<BankEntity> findByEmail(String email);
}
