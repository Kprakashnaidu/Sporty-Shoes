package com.sportyshoes.service;

import com.sportyshoes.entity.ProductEntity;
import com.sportyshoes.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
public class ProductService {

    private final ProductRepository repository;

    public List<ProductEntity> findAll() {
        return repository.findAll();
    }

    public ProductEntity save(ProductEntity product) {
        return repository.save(product);
    }

    @Transactional
    public Optional<ProductEntity> findById(Integer userId) {
        return repository.findById(userId);
    }

    public List<ProductEntity> findByType(String type) {
        return repository.findByType(type);
    }

    @Transactional
    public List<ProductEntity> findByBrand(String brand) {
        return repository.findByBrand(brand);
    }

    @Transactional
    public List<ProductEntity> findAllBySuitableFor(String suitableFor) {
        return repository.findAllBySuitableFor(suitableFor);
    }

    public ProductEntity findByIdAndSuitableFor(String suitableFor, Integer id) {
        return repository.findByIdAndSuitableFor(suitableFor, id);
    }

    public ProductEntity findByIdAndType(String type, Integer id) {
        return repository.findByIdAndType(type, id);
    }

    @Transactional
    public ProductEntity findByIdAndBrand(String brand, Integer id) {
        return repository.findByIdAndBrand(brand, id);
    }

    @Transactional
    public List<ProductEntity> findAllBySuitableForAndType(String suitableFor, String type) {
        return repository.findAllBySuitableForAndType(suitableFor, type);
    }

    @Transactional
    public ProductEntity findByIdAndSuitableForAndType(String suitableFor, String type, Integer id) {
        return repository.findByIdAndSuitableForAndType(suitableFor, type, id);
    }

    public List<ProductEntity> saveAll(List products) {
        return repository.saveAll(products);
    }

    @Transactional
    public void deleteById(Integer userId) {
        repository.deleteById(userId);
    }

    public void delete(ProductEntity product) {
        repository.delete(product);
    }
}
