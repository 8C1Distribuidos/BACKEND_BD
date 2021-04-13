package com.weine.repositories.jpa;

import com.weine.entities.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICityRep extends JpaRepository<City, Integer> {
}
