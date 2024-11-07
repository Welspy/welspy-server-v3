package com.project.welspyserverv3.domain.s3.domain.repository;

import com.project.welspyserverv3.domain.s3.domain.entity.ImageEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface S3JpaRepository extends JpaRepository<ImageEntity, Long> {
}
