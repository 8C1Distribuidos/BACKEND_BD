package com.weine.services;

import com.weine.entities.User;
import com.weine.mappers.IUserMapper;
import com.weine.model.dtos.UserDto;
import com.weine.repositories.jpa.IUserRep;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * All the functions to manage the users
 * @author Luis
 */
@RequiredArgsConstructor
@Service
public class UserService {
    Logger logger = LoggerFactory.getLogger(UserService.class);
    private final IUserMapper userMapper;
    private final IUserRep userRep;
    /**
     * Function to show the products in pages
     * @param pageable The details of the page
     * @return The Page of users dto
     */
    public Page<UserDto> getUsers(Pageable pageable)
    {
        Page<User> users = userRep.findAll(pageable);
        Page<UserDto> map = users.map(userMapper::toUserDto);
        return map;
    }
}
