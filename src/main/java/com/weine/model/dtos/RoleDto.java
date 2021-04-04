package com.weine.model.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Role Dto to show the general info of the <b>roles</b> as the: <br>
 * {@link #id} to keep the id of the role.<br>
 * {@link #role} to keep the role name.<br>
 * @author Luis
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoleDto implements Serializable {
    Integer id;
    String role;
}
