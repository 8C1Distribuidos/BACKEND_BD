package com.weine.services;

import com.weine.model.TicketDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * All the functions to manage the tickets
 * @author Luis
 */
@Service
public class TicketService {
    Logger logger = LoggerFactory.getLogger(UserService.class);
    List<TicketDto> ticketList = new ArrayList<>();

    public TicketService()
    {
        TicketDto ticket1 = new TicketDto();
        ticket1.setDate(LocalDate.of(2021,2,2));
        ticket1.setId(100);
        ticket1.setPriceTotal(250);

        TicketDto ticket2 = new TicketDto();
        ticket2.setDate(LocalDate.of(2021,3,22));
        ticket2.setId(1101);
        ticket2.setPriceTotal(2050);
        ticketList.add(ticket1);
        ticketList.add(ticket2);
    }

    public Page<TicketDto> getTickets(Pageable pageable)
    {
        Page<TicketDto> userTicket = new PageImpl<>(this.ticketList);
        return  userTicket;
    }
}
