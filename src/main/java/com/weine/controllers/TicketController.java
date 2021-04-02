package com.weine.controllers;

import com.weine.model.dtos.TicketDto;
import com.weine.services.IServiceApi;
import com.weine.services.TicketService;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller to map the http request of the ticket interface
 * @author Luis
 */
@RestController
@RequestMapping("/tickets")
public class TicketController extends ControllerApi<TicketDto, Object, TicketService>{

    public TicketController(IServiceApi<TicketDto, Object> service) {
        super(service);
        logger = LoggerFactory.getLogger(TicketController.class);
    }

    @GetMapping
    @Override
    public ResponseEntity<Page<TicketDto>> getPage(Pageable pageProp) {
        return super.getPage(pageProp);
    }

    @Override
    protected String getEntityName() {
        return "Ticket";
    }

    @Override
    protected String getEntityPluralName() {
        return "Tickets";
    }
}
