package com.weine.model.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

/**
 * User Dto to show the general info of the <b>users</b> as the:
 * {@link #id} to keep the id of the user.<br>
 * {@link #firstName} to keep the first name of the user.<br>
 * {@link #paternalName} to keep the paternal name of the user.<br>
 * {@link #maternalName} to keep the maternal name of the user.<br>
 * {@link #email} to keep the email of the user.</br>
 * {@link #birthDate} to keep the birth date of the user.</br>
 * {@link #roles} to keep the roles of the user.</br>
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
    List<RoleDto> roles;
}
