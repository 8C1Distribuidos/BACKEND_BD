package com.weine.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

/**
 * User Dto to show the general info of the users
 * @author Luis
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto implements Serializable {
    Integer id;
    String firstName;
    String paternalName;
    String maternalName;
    String email;
    String photo;
    String password;
    LocalDate birthDate;
    List<RoleDto> roleList;
}
