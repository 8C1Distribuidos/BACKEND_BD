package com.weine.controllers;

import com.weine.model.dtos.UserDto;
import com.weine.services.IServiceApi;
import com.weine.services.UserService;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Controller to map the http request of the catalog interface
 * @author Luis
 */
@RestController
@RequestMapping("/users")
public class UserController extends ControllerApi<UserDto, Object, UserService>{

    public UserController(IServiceApi<UserDto, Object> service) {
        super(service);
        logger = LoggerFactory.getLogger(UserController.class);
    }

    @GetMapping
    @Override
    public ResponseEntity<Page<UserDto>> getPage(Pageable pageProp) {
        return super.getPage(pageProp);
    }

    @GetMapping("/find")
    @Override
    public ResponseEntity<UserDto> findObject(int id) {
        return super.findObject(id);
    }

    @PostMapping
    @Override
    public ResponseEntity<UserDto> saveObject(@RequestBody UserDto requestObject) {
        return super.saveObject(requestObject);
    }

    @PutMapping
    @Override
    public ResponseEntity<UserDto> updateObject(@RequestBody UserDto requestObject) {
        return super.updateObject(requestObject);
    }

    @DeleteMapping
    @Override
    public ResponseEntity<?> deleteObject(int id) {
        return super.deleteObject(id);
    }

    @Override
    protected String getEntityName() {
        return "User";
    }

    @Override
    protected String getEntityPluralName() {
        return "Users";
    }
}