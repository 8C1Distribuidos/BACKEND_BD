package com.weine.services;

import com.weine.entities.Ticket;
import com.weine.mappers.ITicketMapper;
import com.weine.model.dtos.TicketDto;
import com.weine.repositories.jpa.ITicketRep;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.annotation.ReadOnlyProperty;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * All the functions to manage the tickets
 * @author Luis
 */
@RequiredArgsConstructor
@Service
@Transactional
public class TicketService {
    Logger logger = LoggerFactory.getLogger(UserService.class);
    private final ITicketRep ticketRep;
    private final ITicketMapper ticketMapper;
    /**
     * Function to show the tickets in pages
     * @param pageable The details of the page
     * @return The Page of tickets dto
     */
    @ReadOnlyProperty
    public Page<TicketDto> getTickets(Pageable pageable)
    {
        Page<Ticket> tickets = ticketRep.findAll(pageable);
        Page<TicketDto> map = tickets.map((ticketMapper::toTicketDto));
        return map;
    }
}
