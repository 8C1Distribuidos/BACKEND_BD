package com.weine.mappers;

import com.weine.entities.BankAccount;
import com.weine.model.dtos.BankAccountDto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;

import java.util.List;

@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface IBankMapper {
    BankAccountDto toBankAccountDto(BankAccount bankAccount);

    @InheritInverseConfiguration
    BankAccount toBankAccount(BankAccountDto bankAccount);

    List<BankAccountDto> toAccountDtoList(List<BankAccount> bankAccounts);
}
