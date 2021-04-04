package com.weine.model.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Bank Account Dto to wrap the info of <b>bank accounts</b> as the: <br>
 * {@link #id} to keep the id of the account.<br>
 * {@link #cardNumber} to keep the cardNumber of the account.<br>
 * {@link #cvv} to keep the security code.<br>
 * {@link #balance} to keep the money balance of the account.<br>
 * {@link #pin} to keep the pin to use this card.<br>
 * @author Luis
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BankAccountDto {
    private Integer id;
    private String cardNumber;
    private String cvv;
    private Integer balance;
    private String pin;
}
