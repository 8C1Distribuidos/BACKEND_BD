package com.weine.model.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.minidev.json.annotate.JsonIgnore;

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
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    boolean toDelete = false;
}
