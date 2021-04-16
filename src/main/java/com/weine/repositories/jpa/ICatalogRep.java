package com.weine.repositories.jpa;

import com.weine.entities.Catalog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICatalogRep extends JpaRepository<Catalog, Integer> {
}
