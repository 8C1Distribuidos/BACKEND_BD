package com.weine.model.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Ticket Dto to show the general info of the purchases as individual item
 * @author Luis
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PurchaseItemDto implements Serializable {
    Integer idItem;
    ProductDto product;
    Integer amount;
}
