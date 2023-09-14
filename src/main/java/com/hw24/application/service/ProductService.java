package com.hw24.application.service;

import com.hw24.application.persistence.entity.ProductEntity;
import com.hw24.application.persistence.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public Optional<ProductEntity> findProductById(Long id){
        return this.productRepository.findById(id);
    }

    public List<ProductEntity> findAllProducts(){
        return this.productRepository.findAll();
    }

    public void addProduct(ProductEntity productEntity){
        this.productRepository.save(productEntity);
    }


}

