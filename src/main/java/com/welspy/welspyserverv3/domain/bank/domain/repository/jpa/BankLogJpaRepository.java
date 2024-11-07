package com.welspy.welspyserverv3.domain.bank.domain.repository.jpa;

import com.welspy.welspyserverv3.domain.bank.domain.entity.BankLogEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankLogJpaRepository extends JpaRepository<BankLogEntity, Long> {
}
