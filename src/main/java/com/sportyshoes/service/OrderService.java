package com.sportyshoes.service;

import com.sportyshoes.entity.OrderEntity;
import com.sportyshoes.repository.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
public class OrderService {

    private final OrderRepository repository;

    @Transactional
    public List<OrderEntity> findAll() {
        return repository.findAll();
    }

    public OrderEntity save(OrderEntity order) {
        return repository.save(order);
    }

    @Transactional
    public Optional<OrderEntity> findById(Integer userId) {
        return repository.findById(userId);
    }

    public List<OrderEntity> saveAll(List orders) {
        return repository.saveAll(orders);
    }

    public void deleteById(Integer userId) {
        repository.deleteById(userId);
    }

    public void delete(OrderEntity order) {
        repository.delete(order);
    }
}
