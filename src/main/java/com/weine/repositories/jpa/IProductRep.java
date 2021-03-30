package com.weine.repositories.jpa;

import com.weine.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductRep extends JpaRepository<Product, Integer> {
}
