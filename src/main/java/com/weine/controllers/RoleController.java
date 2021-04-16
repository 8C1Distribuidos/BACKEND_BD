package com.weine.controllers;

import com.weine.model.dtos.RoleDto;
import com.weine.services.IServiceApi;
import com.weine.services.RoleService;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Controller to map the http request of the role interface
 * @author Luis
 */
@RestController
@RequestMapping("/roles")
public class RoleController extends ControllerApi<RoleDto, Object, RoleService>{
    public RoleController(IServiceApi<RoleDto, Object> service) {
        super(service);
        logger = LoggerFactory.getLogger(RoleController.class);
    }

    @GetMapping
    @Override
    public ResponseEntity<List<RoleDto>> getObjects() {
        return super.getObjects();
    }

    @GetMapping("/find")
    @Override
    public ResponseEntity<RoleDto> findObject(int id) {
        return super.findObject(id);
    }

    @Override
    protected String getEntityName() {
        return null;
    }

    @Override
    protected String getEntityPluralName() {
        return null;
    }
}
