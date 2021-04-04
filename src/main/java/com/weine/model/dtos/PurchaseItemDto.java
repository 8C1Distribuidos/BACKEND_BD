package com.weine.model.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Ticket Dto to show the general <b>info of the purchases as individual item</b> as the:
 * {@link #idItem} to keep the id of the purchase.<br>
 * {@link #product} to keep the product relation of the purchase.<br>
 * {@link #amount} to keep the amount of the products.<br>
 * {@link #toDelete} is used to know if the item must to be deleted when is called the method update.
 * if {@link #toDelete} is {@code true} this object is going to be deleted in the database and if
 * is {@code false} it is going to be updated. Also this field is <b>just writeable</b> so is not going to be read when this objects
 * go outside.<br>
 * @author Luis
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PurchaseItemDto implements Serializable {
    Integer idItem;
    ProductDto product;
    Integer amount;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    boolean toDelete = false;
}
