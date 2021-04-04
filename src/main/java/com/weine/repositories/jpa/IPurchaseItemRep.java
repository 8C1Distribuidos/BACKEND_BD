package com.weine.repositories.jpa;

import com.weine.entities.PurchaseItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPurchaseItemRep extends JpaRepository<PurchaseItem, Integer> {
}
