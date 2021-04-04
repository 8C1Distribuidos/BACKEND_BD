package com.weine.services;

import com.weine.entities.Ticket;
import com.weine.mappers.ITicketMapper;
import com.weine.model.dtos.PurchaseItemDto;
import com.weine.model.dtos.TicketDto;
import com.weine.repositories.jpa.IPurchaseItemRep;
import com.weine.repositories.jpa.ITicketRep;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

/**
 * All the functions to manage the tickets
 * @author Luis
 */
@RequiredArgsConstructor
@Service
@Transactional
public class TicketService implements IServiceApi<TicketDto, Object>{
    private final ITicketRep ticketRep;
    private final ITicketMapper ticketMapper;
    private final IPurchaseItemRep purchaseItemRep;

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
    public TicketDto save(TicketDto request) {
        if(request != null)
        {
            request.setId(null);
            Ticket ticket = ticketMapper.toTicket(request);
            ticketMapper.setRelation(ticket, true);
            Ticket response = ticketRep.saveAndFlush(ticket);
            return  ticketMapper.toTicketDto(response);
        }
        return null;
    }

    @Override
    public TicketDto update(TicketDto request) {
        if(request != null) {
            if(checkExistence(request.getId())) {
                if(request.getPurchaseList() != null) {
                    Set<PurchaseItemDto> itemsToDelete = new HashSet<>();
                    for (PurchaseItemDto item : request.getPurchaseList()) {
                        if(item.isToDelete()){//Delete the items of the list that must to be deleted
                            purchaseItemRep.deleteById(item.getIdItem());
                            itemsToDelete.add(item);
                        }
                    }
                    //And remove the request list
                    request.getPurchaseList().removeAll(itemsToDelete);
                }
                Ticket ticket = ticketMapper.toTicket(request);
                ticketMapper.setRelation(ticket, false);

                Ticket response = ticketRep.saveAndFlush(ticket);
                return ticketMapper.toTicketDto(response);
            }
        }
        return null;
    }

    @Override
    public boolean delete(Integer id) {
        if(id != null)
        {
            ticketRep.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public boolean checkExistence(Integer id) {
        if(id != null)
            return ticketRep.findById(id).isPresent();
        return false;
    }
}
