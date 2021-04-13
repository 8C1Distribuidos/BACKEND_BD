package com.weine.repositories.jpa;

import com.weine.entities.PurchaseItem;
import com.weine.entities.PurchaseItemId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPurchaseItemRep extends JpaRepository<PurchaseItem, PurchaseItemId> {
}
