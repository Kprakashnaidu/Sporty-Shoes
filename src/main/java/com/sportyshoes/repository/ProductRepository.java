package com.sportyshoes.repository;

import com.sportyshoes.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Integer> {

    List<ProductEntity> findByType(String type);

    List<ProductEntity> findByBrand(String brand);

    @Query("FROM ProductEntity p WHERE p.suitableFor = ?1")
    List<ProductEntity> findAllBySuitableFor(String suitableFor);

    @Query("FROM ProductEntity p WHERE p.suitableFor = ?1 AND p.type = ?2")
    List<ProductEntity> findAllBySuitableForAndType(String suitableFor, String type);

    @Query("FROM ProductEntity p WHERE p.suitableFor = ?1 AND p.id = ?2")
    ProductEntity findByIdAndSuitableFor(String suitableFor, Integer id);

    @Query("FROM ProductEntity p WHERE p.type = ?1 AND p.id = ?2")
    ProductEntity findByIdAndType(String type, Integer id);

    @Query("FROM ProductEntity p WHERE p.brand = ?1 AND p.id = ?2")
    ProductEntity findByIdAndBrand(String brand, Integer id);

    @Query("FROM ProductEntity p WHERE p.suitableFor = ?1 AND p.type = ?2 AND p.id = ?3")
    ProductEntity findByIdAndSuitableForAndType(String suitableFor, String type, Integer id);
}
