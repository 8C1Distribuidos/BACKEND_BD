package com.weine.controllers;

import com.weine.exception.ApiRequestException;
import com.weine.model.dtos.LoginDto;
import com.weine.model.dtos.UserDto;
import com.weine.services.IServiceApi;
import com.weine.services.UserService;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
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

    @PostMapping("/verify")
    public ResponseEntity<UserDto> verifyUser(@RequestBody LoginDto credentials)
    {
        logger.info("Verifying "+ getEntityPluralName()+" " + credentials + "...");
        UserService userService = (UserService) service;
        UserDto response = userService.verifyUser(credentials.getEmail(), credentials.getPassword());
        if(response == null)
        {
            logger.info(getEntityName() + " " + credentials + " has not been verified...");
            throw new ApiRequestException("Wrong credentials", HttpStatus.NOT_FOUND);
        }
        logger.info(getEntityName()+"s verified...");
        return ResponseEntity.ok(response);
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