package com.weine.repositories.jpa;

import com.weine.entities.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ITicketRep extends JpaRepository<Ticket, Integer> {
    List<Ticket> findAllByIdUser(Integer idUser);
}
