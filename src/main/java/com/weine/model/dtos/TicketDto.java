package com.weine.model.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

/**
 * Ticket Dto to show the general info of the <b>tickets</b> as the:
 * {@link #id} to keep the id of the ticket.<br>
 * {@link #idUser} to keep the id of the user that make this purchase.<br>
 * {@link #dateTime} to keep the date of the purchase.<br>
 * {@link #totalPrice} to keep the total price.<br>
 * {@link #city} the city of the address.<br>
 * {@link #purchaseList} to keep the list of products purchased.<br>
 * @author Luis
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TicketDto implements Serializable {
    private Integer id;
    private Integer idUser;
    private LocalDateTime dateTime;
    private Integer totalPrice;
    private String zipCode;
    private String address;
    private CityDto city;
    private Set<PurchaseItemDto> purchaseList = new HashSet<>();
}
