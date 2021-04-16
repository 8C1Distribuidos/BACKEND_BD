package com.weine.controllers;

import com.weine.model.dtos.CatalogDto;
import com.weine.services.CatalogService;
import com.weine.services.IServiceApi;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Controller to map the http request of the catalog interface
 * @author Luis
 */
@RestController
@RequestMapping("/catalogs")
public class CatalogController extends ControllerApi<CatalogDto,Object, CatalogService>{
    public CatalogController(IServiceApi<CatalogDto, Object> service) {
        super(service);
        logger = LoggerFactory.getLogger(CatalogController.class);
    }

    @GetMapping
    @Override
    public ResponseEntity<List<CatalogDto>> getObjects() {
        return super.getObjects();
    }

    @GetMapping("/find")
    @Override
    public ResponseEntity<CatalogDto> findObject(int id) {
        return super.findObject(id);
    }

    @Override
    protected String getEntityName() {
        return "Catalog";
    }

    @Override
    protected String getEntityPluralName() {
        return "Catalogs";
    }
}
