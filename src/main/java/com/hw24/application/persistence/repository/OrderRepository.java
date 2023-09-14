package com.hw24.application.persistence.repository;

import com.hw24.application.persistence.entity.OrderEntity;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.ListPagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

public interface OrderRepository extends ListCrudRepository<OrderEntity, Long>, ListPagingAndSortingRepository<OrderEntity, Long> {
    @Query("""
            INSERT INTO "order_product" ("order_id", "product_id") VALUES (:orderId, :productId);
            """)
    @Modifying
    void assignProductToOrder(@Param("orderId") long orderId, @Param("productId") long productId);
}