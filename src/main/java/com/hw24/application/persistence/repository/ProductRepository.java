package com.hw24.application.persistence.repository;

import com.hw24.application.persistence.entity.ProductEntity;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.ListPagingAndSortingRepository;

public interface ProductRepository extends ListCrudRepository<ProductEntity, Long>, ListPagingAndSortingRepository<ProductEntity, Long> {

}

