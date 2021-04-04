package com.weine.services;

import com.weine.entities.User;
import com.weine.mappers.IUserMapper;
import com.weine.model.dtos.UserDto;
import com.weine.repositories.jpa.IUserRep;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * All the functions to manage the users
 * @author Luis
 */
@RequiredArgsConstructor
@Service
public class UserService implements IServiceApi<UserDto, Object>{
    private final IUserMapper userMapper;
    private final IUserRep userRep;

    @Override
    public Page<UserDto> getPage(Pageable pageable) {
        Page<User> users = userRep.findAll(pageable);
        return users.map(userMapper::toUserDto);
    }

    @Override
    public UserDto find(Integer id) {
        if(id != null) {
            Optional<User> userOp = userRep.findById(id);
            if(userOp.isPresent())
            {
                User user = userOp.get();
                return userMapper.toUserDto(user);
            }
        }
        return null;
    }

    @Override
    public UserDto save(UserDto request) throws RuntimeException {
        if(request != null)
        {
            request.setId(null);
            User user = userMapper.toUser(request);
            User response = userRep.save(user);
            return userMapper.toUserDto(response);
        }
        return null;
    }

    @Override
    public UserDto update(UserDto request) throws RuntimeException {
        if(request != null)
        {
            if(checkExistence(request.getId())) {
                User user = userMapper.toUser(request);
                User response = userRep.save(user);
                return userMapper.toUserDto(response);
            }
        }
        return null;
    }

    @Override
    public boolean delete(Integer id) throws RuntimeException {
        if(id != null)
        {
            userRep.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public boolean checkExistence(Integer id) {
        return false;
    }
}
