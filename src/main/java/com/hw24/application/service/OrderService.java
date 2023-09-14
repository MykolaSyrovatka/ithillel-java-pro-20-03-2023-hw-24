package com.hw24.application.service;

import com.hw24.application.persistence.entity.OrderEntity;
import com.hw24.application.persistence.entity.ProductEntity;
import com.hw24.application.persistence.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.GregorianCalendar;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    public Optional<OrderEntity> findOrderById(Long id){
        return this.orderRepository.findById(id);
    }

    public List<OrderEntity> findAllOrders(){
        return this.orderRepository.findAll();
    }

    public void addOrder(OrderEntity orderEntity, List<ProductEntity> productEntities){
        Double cost = 0.0;
        orderEntity.setCalendar(new GregorianCalendar());
        for (ProductEntity productEntity:productEntities) {
            cost+=productEntity.getCost();
        }
        orderEntity.setCost(cost);
        this.orderRepository.save(orderEntity);

        productEntities.forEach(productEntity ->
                this.orderRepository.assignProductToOrder(orderEntity.getId(), productEntity.getId()));

    }

}

