package com.weine.mappers;

import com.weine.entities.User;
import com.weine.model.dtos.UserDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IUserMapper {
    UserDto toUserDto(User user);

    List<UserDto> toUserDtoList(List<User> users);
}
