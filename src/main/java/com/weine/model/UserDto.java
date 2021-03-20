package com.weine.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * User Dto to show the general info of the users
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto implements Serializable {
    Integer id;
    String firstName;
    String lastName;
    String email;
    String photo;
}
