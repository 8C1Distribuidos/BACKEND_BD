package com.weine.services;

import com.weine.model.UserDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    Logger logger = LoggerFactory.getLogger(UserService.class);
    List<UserDto> userList = new ArrayList<>();

    public UserService()
    {
        UserDto use1 = new UserDto();
        use1.setEmail("Luis@gmail.com");
        use1.setFirstName("Luis");
        use1.setId(1);
        use1.setPhoto("link/.png");
        use1.setPaternalName("Chavez");
        use1.setMaternalName("Macias");
        use1.setBirthDate(LocalDate.of(2002,8,19));

        UserDto use2 = new UserDto();
        use2.setEmail("Kaleb@gmail.com");
        use2.setFirstName("Kaleb");
        use2.setId(2);
        use2.setPhoto("link/.png");
        use2.setPaternalName("Diaz");
        use2.setMaternalName("Juarez");
        use2.setBirthDate(LocalDate.of(2002,1,1));
        userList.add(use1);
        userList.add(use2);
    }

    public Page<UserDto> getUsers(Pageable pageable)
    {
        List<UserDto> userDtoList = new ArrayList<>();
        Page<UserDto> userDtos = new PageImpl<>(userList);
        return  userDtos;
    }
}
