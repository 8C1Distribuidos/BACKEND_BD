package com.weine.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Ticket Dto to show the general info of the users
 * @author Luis
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TicketDto implements Serializable {
    Integer id;
    LocalDateTime date;
    Integer priceTotal;
    List<PurchaseItemDto> purchaseList;
}
