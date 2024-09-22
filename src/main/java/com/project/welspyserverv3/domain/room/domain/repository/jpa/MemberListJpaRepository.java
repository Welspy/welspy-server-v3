package com.project.welspyserverv3.domain.room.domain.repository.jpa;

import com.project.welspyserverv3.domain.room.domain.entity.MemberListEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberListJpaRepository extends JpaRepository<MemberListEntity, Long> {
}
