package com.weine.mappers;

import com.weine.entities.PurchaseItem;
import com.weine.entities.Ticket;
import com.weine.model.dtos.PurchaseItemDto;
import com.weine.model.dtos.TicketDto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueCheckStrategy;


@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface ITicketMapper {

    @Mapping(target = "purchaseList", source = "purchaseItems")
    TicketDto toTicketDto(Ticket ticket);

    @InheritInverseConfiguration
    Ticket toTicket(TicketDto ticketDto);

    @Mapping(target = "toDelete", ignore = true)
    @Mapping(target = "idItem", source = "id")
    PurchaseItemDto toPurchaseItemDto(PurchaseItem purchaseItem);

    @InheritInverseConfiguration
    PurchaseItem toPurchaseItem(PurchaseItemDto purchaseItemDto);

    default void setRelation(Ticket ticket, boolean isToSave){
        if(ticket.getPurchaseItems() != null)
        {
            for (PurchaseItem item : ticket.getPurchaseItems())
            {
                if(isToSave)
                {
                    item.setId(null);//To clear this field
                }
                item.setTicket(ticket);
            }
        }
    }
}
