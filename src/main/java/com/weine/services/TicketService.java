package com.weine.services;

import com.weine.model.dtos.PurchaseItemDto;
import com.weine.model.dtos.TicketDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * All the functions to manage the tickets
 * @author Luis
 */
@Service
public class TicketService {
    Logger logger = LoggerFactory.getLogger(UserService.class);
    List<TicketDto> ticketList = Arrays.asList(
            new TicketDto(1,LocalDateTime.now(),250, Collections.singletonList(new PurchaseItemDto(1, ProductService.PRODUCT_LIST.get(0), 2))),
            new TicketDto(2022,LocalDateTime.now(),2050, Collections.singletonList(new PurchaseItemDto(1, ProductService.PRODUCT_LIST.get(0), 5)))
    );

    public Page<TicketDto> getTickets(Pageable pageable)
    {
        Page<TicketDto> userTicket = new PageImpl<>(this.ticketList);
        return  userTicket;
    }
}
