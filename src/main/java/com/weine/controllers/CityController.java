package com.weine.controllers;

import com.weine.model.dtos.CityDto;
import com.weine.services.CityService;
import com.weine.services.IServiceApi;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Controller to map the http request of the city interface
 * @author Kaleb
 */
@RestController
@RequestMapping("/cities")
public class CityController extends ControllerApi<CityDto, Object, CityService>{

    public CityController(IServiceApi<CityDto, Object> service) {
        super(service);
        logger = LoggerFactory.getLogger(CityController.class);
    }

    @GetMapping
    @Override
    public ResponseEntity<List<CityDto>> getObjects() {
        return super.getObjects();
    }

    @GetMapping("/find")
    @Override
    public ResponseEntity<CityDto> findObject(int id) {
        return super.findObject(id);
    }

    @Override
    protected String getEntityName() {
        return "City";
    }

    @Override
    protected String getEntityPluralName() {
        return "Cities";
    }
}
