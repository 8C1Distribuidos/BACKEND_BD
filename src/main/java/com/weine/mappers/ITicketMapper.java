package com.weine.mappers;

import com.weine.entities.City;
import com.weine.entities.PurchaseItem;
import com.weine.entities.Ticket;
import com.weine.model.dtos.CityDto;
import com.weine.model.dtos.PurchaseItemDto;
import com.weine.model.dtos.TicketDto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueCheckStrategy;

import java.util.List;


@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface ITicketMapper {

    @Mapping(target = "purchaseList", source = "purchaseItems")
    TicketDto toTicketDto(Ticket ticket);

    List<TicketDto> ticketsToTicketsDto(List<Ticket> ticket);

    @InheritInverseConfiguration
    Ticket toTicket(TicketDto ticketDto);

    @Mapping(target = "toDelete", ignore = true)
    @Mapping(target = "id", source = "product.id")
    PurchaseItemDto toPurchaseItemDto(PurchaseItem purchaseItem);

    @Mapping(target = "ticket", ignore = true)
    @Mapping(target = "product.id", source = "id")
    @Mapping(target = "id.idProduct", source = "id")
    PurchaseItem toPurchaseItem(PurchaseItemDto purchaseItemDto);

    List<CityDto> cityListToCityDtoList(List<City> cities);

    CityDto toCity(City city);

    @Mapping(target = "tickets", ignore = true)
    City cityDtoToCity(CityDto cityDto);

    default void setRelation(Ticket ticket){
        if(ticket.getPurchaseItems() != null)
        {
            for (PurchaseItem item : ticket.getPurchaseItems())
            {
                item.setTicket(ticket);
            }
        }
    }
}
