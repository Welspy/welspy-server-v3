package com.project.welspyserverv3.domain.room.domain.repository.jpa;

import com.project.welspyserverv3.domain.room.domain.entity.RoomEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomJpaRepository extends JpaRepository<RoomEntity, Long> {
}