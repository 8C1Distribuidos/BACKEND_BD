package com.weine.model.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Credentials Dto to wrap the credentials of the user, as the.<br>
 * {@code email} the email of the user.<br>
 * {@code password} the password of the user.<br>
 * @author Luis
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginDto {
    private String email;
    private String password;

    @Override
    public String toString() {
        return "LoginDto{" +
                "email='" + email + '\'' +
                ", password=-------'" + '\'' +
                '}';
    }
}
