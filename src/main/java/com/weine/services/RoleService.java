package com.weine.services;

import com.weine.entities.Role;
import com.weine.mappers.IUserMapper;
import com.weine.model.dtos.RoleDto;
import com.weine.repositories.jpa.IRoleRep;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Service to get the roles information
 * @author Luis
 */
@RequiredArgsConstructor
@Service
public class RoleService implements IServiceApi<RoleDto, Object>{
    private final IRoleRep roleRep;
    private final IUserMapper userMapper;

    @Override
    public List<RoleDto> getObjects() {
        return userMapper.toRoleDtoList(roleRep.findAll());
    }

    @Override
    public RoleDto find(Integer id) {
        if(id != null){
            Optional<Role> optional = roleRep.findById(id);
            if(optional.isPresent()){
                return userMapper.toRoleDto(optional.get());
            }
        }
        return null;
    }

    @Override
    public RoleDto save(RoleDto request) throws RuntimeException {
        return null;
    }

    @Override
    public RoleDto update(RoleDto request) throws RuntimeException {
        return null;
    }

    @Override
    public boolean delete(Integer id) throws RuntimeException {
        return false;
    }

    @Override
    public boolean checkExistence(Integer id) {
        return false;
    }
}
