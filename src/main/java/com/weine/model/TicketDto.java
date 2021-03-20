package com.weine.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 * Ticket Dto to show the general info of the users
 * @author Luis
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TicketDto {
    Integer id;
    LocalDate date;
    Integer priceTotal;
}
