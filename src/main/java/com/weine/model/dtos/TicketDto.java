package com.weine.model.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Ticket Dto to show the general info of the users
 * @author Luis
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TicketDto implements Serializable {
    Integer id;
    LocalDateTime dateTime;
    Integer totalPrice;
    Set<PurchaseItemDto> purchaseList = new HashSet<>();
}
