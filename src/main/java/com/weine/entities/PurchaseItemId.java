package com.weine.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class PurchaseItemId implements Serializable {
    @Column(name = "id_ticket",nullable = false)
    private Integer idTicket;
    @Column(name = "id_producto",nullable = false)
    private Integer idProduct;
}
