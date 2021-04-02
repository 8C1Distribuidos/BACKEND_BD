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
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service to get the bank account information
 * @author Luis
 */
@Transactional
@RequiredArgsConstructor
@Service
public class BankService implements IServiceApi<BankAccountDto, Object> {
    Logger logger = LoggerFactory.getLogger(BankService.class);
    private final IBankMapper bankMapper;
    private final IBankRep bankRep;

    @Override
    public Page<BankAccountDto> getPage(Pageable pageable) {
        Page<BankAccount> accounts = bankRep.findAll(pageable);
        return accounts.map(bankMapper::toBankAccountDto);
    }

    @Override
    public BankAccountDto find(Integer id) {
        if(id != null) {
            Optional<BankAccount> pro = bankRep.findById(id);
            if (pro.isPresent()) {
                BankAccount account = pro.get();
                return bankMapper.toBankAccountDto(account);
            }
        }
        return null;
    }

    @Override
    public BankAccountDto save(BankAccountDto request) {
        if(request != null) {
            request.setId(null);//Just to clear the field
            BankAccount bankAccount = bankMapper.toBankAccount(request);
            BankAccount response = bankRep.save(bankAccount);
            return bankMapper.toBankAccountDto(response);
        }
        return null;
    }

    @Override
    public BankAccountDto update(BankAccountDto request) {
        if(request != null) {
            if(find(request.getId()) != null) {//Verify the existence of the account
                BankAccount bankAccount = bankMapper.toBankAccount(request);
                BankAccount response = bankRep.save(bankAccount);
                return bankMapper.toBankAccountDto(response);
            }
        }
        return null;
    }

    @Override
    public boolean delete(Integer id) {
        if(id != null) {
            try {
                bankRep.deleteById(id);
                return true;
            }
            catch (Exception e)
            {
                logger.error(e.getMessage());
            }
        }
        return false;
    }
}
