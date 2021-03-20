package com.weine.controllers;

import com.weine.model.UserDto;
import com.weine.services.UserService;
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
 * Controller to map the http request of the catalog interface
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    Logger logger = LoggerFactory.getLogger(UserController.class);
    private  final UserService userService;

    @GetMapping()
    public ResponseEntity<Page<UserDto>> getCatalogs(
            @PageableDefault(page = 0,size = 5) Pageable pageable
    )
    {
        logger.info("Get users...");
        return ResponseEntity.ok(this.userService.getUsers(pageable));
    }
}