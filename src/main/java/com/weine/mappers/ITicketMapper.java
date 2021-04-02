package com.weine.mappers;

import com.weine.entities.PurchaseItem;
import com.weine.entities.Ticket;
import com.weine.model.dtos.PurchaseItemDto;
import com.weine.model.dtos.TicketDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueCheckStrategy;

@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface ITicketMapper {

    @Mapping(target = "purchaseList", source = "purchaseItems")
    TicketDto toTicketDto(Ticket ticket);

    @Mapping(target = "idItem", source = "id")
    PurchaseItemDto toPurchaseItemDto(PurchaseItem purchaseItem);
}
