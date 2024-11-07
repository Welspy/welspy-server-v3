package com.welspy.welspyserverv3.domain.product.domain.repository.jpa;

import com.welspy.welspyserverv3.domain.product.domain.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductJpaRepository extends JpaRepository<ProductEntity, Long> {
}
