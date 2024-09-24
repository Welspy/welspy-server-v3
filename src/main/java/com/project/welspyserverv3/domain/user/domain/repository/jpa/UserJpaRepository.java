package com.project.welspyserverv3.domain.user.domain.repository.jpa;

import com.project.welspyserverv3.domain.user.domain.entity.UserEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserJpaRepository extends JpaRepository<UserEntity, String> {

    Optional<UserEntity> findByEmail(String email);

    UserEntity getByEmail(String email);

    @Transactional(rollbackOn = Exception.class)
    void deleteByEmail(String email);

}
