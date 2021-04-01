package com.weine.services;

import com.weine.entities.BankAccount;
import com.weine.mappers.IBankMapper;
import com.weine.model.dtos.BankAccountDto;
import com.weine.repositories.jpa.IBankRep;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * Service to get the bank account information
 * @author Luis
 */
@RequiredArgsConstructor
@Service
public class BankService {
    Logger logger = LoggerFactory.getLogger(BankService.class);
    private final IBankMapper bankMapper;
    private final IBankRep bankRep;
    /**
     * Function to show the bank accounts in pages
     * @param pageable The details of the page
     * @return The Page of bank account dto
     */
    public Page<BankAccountDto> getBankAccounts(Pageable pageable)
    {
        Page<BankAccount> accounts = bankRep.findAll(pageable);
        Page<BankAccountDto> map = accounts.map(bankMapper::toBankAccountDto);
        return map;
    }
}
