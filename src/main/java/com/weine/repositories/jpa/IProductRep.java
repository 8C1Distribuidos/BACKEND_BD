package com.weine.repositories.jpa;

import com.weine.entities.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductRep extends JpaRepository<Product, Integer> {
    Page<Product> findAllByNameContaining(String name, Pageable pageable);
    @Query("SELECT u FROM Product u WHERE u.name LIKE %:name% AND u.stock >= :stock")
    Page<Product> findAllWithParams(Pageable pageable, @Param("name") String name, @Param("stock") Integer stock);
}
