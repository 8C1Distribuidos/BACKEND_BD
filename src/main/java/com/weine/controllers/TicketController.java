package com.weine.controllers;

import com.weine.model.criteria.TicketCriteria;
import com.weine.model.dtos.TicketDto;
import com.weine.services.IServiceApi;
import com.weine.services.TicketService;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller to map the http request of the ticket interface
 * @author Luis
 */
@RestController
@RequestMapping("/tickets")
public class TicketController extends ControllerApi<TicketDto, TicketCriteria, TicketService>{

    public TicketController(IServiceApi<TicketDto, TicketCriteria> service) {
        super(service);
        logger = LoggerFactory.getLogger(TicketController.class);
    }

    @PostMapping("/client-history")
    @Override
    public ResponseEntity<List<TicketDto>> getObjects(TicketCriteria criteria) {
        return super.getObjects(criteria);
    }

    @GetMapping
    @Override
    public ResponseEntity<Page<TicketDto>> getPage(Pageable pageProp) {
        return super.getPage(pageProp);
    }

    @PostMapping
    @Override
    public ResponseEntity<TicketDto> saveObject(@RequestBody TicketDto requestObject) {
        return super.saveObject(requestObject);
    }

    @PutMapping
    @Override
    public ResponseEntity<TicketDto> updateObject(@RequestBody TicketDto requestObject) {
        return super.updateObject(requestObject);
    }

    @DeleteMapping
    @Override
    public ResponseEntity<?> deleteObject(int id) {
        return super.deleteObject(id);
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
