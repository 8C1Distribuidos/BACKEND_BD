package com.weine.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

import static javax.persistence.GenerationType.IDENTITY;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cuenta_banco")
public class BankAccount implements Serializable {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "NoCuenta", unique = true, nullable = false)
    private Integer id;
    @Column(name = "NoTarjeta", unique = true, nullable = false, length = 30)
    private String cardNumber;
    @Column(name = "cvv", nullable = false, length = 4)
    private String cvv;
    @Column(name = "saldo", nullable = false)
    private Integer balance;
    @Column(name = "pin", nullable = false)
    private String varchar;
}
