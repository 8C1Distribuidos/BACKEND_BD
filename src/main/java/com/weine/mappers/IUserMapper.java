package com.weine.mappers;

import com.weine.entities.User;
import com.weine.model.dtos.UserDto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;

import java.util.List;

@Mapper(componentModel = "spring" , nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface IUserMapper {
    UserDto toUserDto(User user);

    @InheritInverseConfiguration
    User toUser(UserDto userDto);
    List<UserDto> toUserDtoList(List<User> users);
}
