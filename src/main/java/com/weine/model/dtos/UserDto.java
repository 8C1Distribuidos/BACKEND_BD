package com.weine.model.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * User Dto to show the general info of the <b>users</b> as the:
 * {@link #id} to keep the id of the user.<br>
 * {@link #firstName} to keep the first name of the user.<br>
 * {@link #paternalName} to keep the paternal name of the user.<br>
 * {@link #maternalName} to keep the maternal name of the user.<br>
 * {@link #email} to keep the email of the user.</br>
 * {@link #role} the role of the user.</br>
 * @author Luis
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto implements Serializable {
    private Integer id;
    private String firstName;
    private String paternalName;
    private String maternalName;
    private String email;
    private String photo;
    private String password;
    private RoleDto role;
}
