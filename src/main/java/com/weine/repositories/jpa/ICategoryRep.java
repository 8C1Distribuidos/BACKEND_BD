package com.weine.repositories.jpa;

import com.weine.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICategoryRep extends JpaRepository<Category,Integer> {
}
