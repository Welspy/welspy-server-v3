package com.welspy.welspyserverv3.domain.room.domain.repository.jpa;

import com.welspy.welspyserverv3.domain.room.domain.entity.RoomEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoomJpaRepository extends JpaRepository<RoomEntity, Long> {
    @Transactional(rollbackOn = Exception.class)
    void deleteByRoomId(Long roomId);
    List<RoomEntity> findRoomEntitiesByRoomIdIn(List<Long> roomIds);
}
