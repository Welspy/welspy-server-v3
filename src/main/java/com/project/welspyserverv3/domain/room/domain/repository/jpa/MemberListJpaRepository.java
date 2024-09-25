package com.project.welspyserverv3.domain.room.domain.repository.jpa;

import com.project.welspyserverv3.domain.room.domain.entity.MemberListEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberListJpaRepository extends JpaRepository<MemberListEntity, Long> {
    Optional<MemberListEntity> findByEmailAndRoomId(String email, Long roomId);
}
