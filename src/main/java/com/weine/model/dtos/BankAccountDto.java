package com.weine.model.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BankAccountDto {
    private Integer id;
    private String cardNumber;
    private String cvv;
    private Integer balance;
    private String varchar;
}
