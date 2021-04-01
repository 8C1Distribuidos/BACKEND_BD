package com.weine.mappers;

import com.weine.entities.BankAccount;
import com.weine.model.dtos.BankAccountDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IBankMapper {
    BankAccountDto toBankAccountDto(BankAccount bankAccount);

    List<BankAccountDto> toAccountDtoList(List<BankAccount> bankAccounts);
}
