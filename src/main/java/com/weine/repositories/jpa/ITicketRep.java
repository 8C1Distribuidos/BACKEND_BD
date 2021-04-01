package com.weine.repositories.jpa;

import com.weine.entities.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITicketRep extends JpaRepository<Ticket, Integer> {
}
