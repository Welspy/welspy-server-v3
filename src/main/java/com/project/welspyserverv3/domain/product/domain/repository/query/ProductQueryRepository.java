package com.project.welspyserverv3.domain.product.domain.repository.query;

import com.project.welspyserverv3.domain.product.client.dto.Product;
import com.project.welspyserverv3.domain.product.client.dto.request.ProductSearchRequest;
import com.project.welspyserverv3.global.common.dto.request.PageRequest;
import com.querydsl.core.types.ConstructorExpression;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.project.welspyserverv3.domain.product.domain.entity.QProductEntity.productEntity;

@Repository
@RequiredArgsConstructor
public class ProductQueryRepository {

    private final JPAQueryFactory jpaQueryFactory;

    public List<Product> productList(PageRequest request) {
        return jpaQueryFactory
                .select(productConstructorExpression())
                .from(productEntity)
                .offset((long) (request.getPage() - 1) * request.getSize())
                .limit(request.getSize())
                .orderBy(productEntity.idx.desc())
                .fetch();
    }

    public List<Product> productSearch(ProductSearchRequest request) {
        return jpaQueryFactory
                .select(productConstructorExpression())
                .from(productEntity)
                .where(productEntity.name.contains(request.getName()))
                .offset((long) (request.getPage() - 1) * request.getSize())
                .limit(request.getSize())
                .orderBy(productEntity.idx.desc())
                .fetch();
    }

    private ConstructorExpression<Product> productConstructorExpression(){
        return Projections.constructor(Product.class,
                productEntity.idx,
                productEntity.name,
                productEntity.description,
                productEntity.price,
                productEntity.discount,
                productEntity.discountedPrice,
                productEntity.imageUrl
        );
    }

}
