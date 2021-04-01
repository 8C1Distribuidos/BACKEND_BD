package com.weine.repositories.jpa;

import com.weine.entities.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBankRep extends JpaRepository<BankAccount, Integer> {
}
