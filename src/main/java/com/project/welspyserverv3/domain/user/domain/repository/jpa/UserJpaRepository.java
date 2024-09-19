package com.project.welspyserverv3.domain.user.domain.repository.jpa;

import com.project.welspyserverv3.domain.user.domain.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserJpaRepository extends JpaRepository<UserEntity, Long> {

    Optional<UserEntity> findByEmail(String email);

    UserEntity getByEmail(String email);

}
