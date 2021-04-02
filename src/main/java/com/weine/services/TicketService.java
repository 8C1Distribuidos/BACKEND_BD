package com.weine.services;

import com.weine.entities.Category;
import com.weine.entities.Ticket;
import com.weine.mappers.ITicketMapper;
import com.weine.model.criteria.PageProp;
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

import java.util.Optional;

/**
 * All the functions to manage the tickets
 * @author Luis
 */
@RequiredArgsConstructor
@Service
@Transactional
public class TicketService implements IServiceApi<TicketDto, Object>{
    Logger logger = LoggerFactory.getLogger(UserService.class);
    private final ITicketRep ticketRep;
    private final ITicketMapper ticketMapper;

    @Override
    public Page<TicketDto> getPage(Pageable pageable) {
        Page<Ticket> tickets = ticketRep.findAll(pageable);
        return tickets.map((ticketMapper::toTicketDto));
    }

    @Override
    public TicketDto find(Integer id) {
        if(id != null) {
            Optional<Ticket> pro = ticketRep.findById(id);
            if (pro.isPresent()) {
                Ticket response = pro.get();
                return ticketMapper.toTicketDto(response);
            }
        }
        return null;
    }

    @Override
    public TicketDto save(TicketDto request) throws RuntimeException {
        return null;
    }

    @Override
    public TicketDto update(TicketDto request) throws RuntimeException {
        return null;
    }

    @Override
    public boolean delete(Integer id) {
        return false;
    }
}
