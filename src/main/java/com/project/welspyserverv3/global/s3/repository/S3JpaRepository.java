package com.project.welspyserverv3.global.s3.repository;

import com.project.welspyserverv3.global.s3.entity.ImageEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface S3JpaRepository extends JpaRepository<ImageEntity, Long> {
}
