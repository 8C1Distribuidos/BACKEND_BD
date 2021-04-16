package com.weine.mappers;

import com.weine.entities.Role;
import com.weine.entities.User;
import com.weine.model.dtos.RoleDto;
import com.weine.model.dtos.UserDto;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring" , nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface IUserMapper {
    UserDto toUserDto(User user);

    @InheritInverseConfiguration
    User toUser(UserDto userDto);

    RoleDto toRoleDto(Role role);

    List<RoleDto> toRoleDtoList(List<Role> roles);

    List<UserDto> toUserDtoList(List<User> users);
}
