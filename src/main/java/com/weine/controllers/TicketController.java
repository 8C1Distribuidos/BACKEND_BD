package com.weine.controllers;

import com.weine.model.dtos.TicketDto;
import com.weine.services.TicketService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller to map the http request of the ticket interface
 * @author Luis
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/tickets")
public class TicketController {
    Logger logger = LoggerFactory.getLogger(TicketController.class);
    private  final TicketService ticketService;

    @GetMapping()
    public ResponseEntity<Page<TicketDto>> getTickets(
            @PageableDefault(page = 0,size = 5) Pageable pageable
    )
    {
        logger.info("Get tickets...");
        ResponseEntity<Page<TicketDto>> response = ResponseEntity.ok(this.ticketService.getTickets(pageable));
        logger.info("Ticket obtained...");
        return response;
    }
}
