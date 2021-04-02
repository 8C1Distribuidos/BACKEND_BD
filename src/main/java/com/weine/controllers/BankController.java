package com.weine.controllers;

import com.weine.model.dtos.BankAccountDto;
import com.weine.services.BankService;
import com.weine.services.IServiceApi;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Controller to map the http request of the bank account interface
 * @author Kaleb
 * @author Luis
 */
@RestController
@RequestMapping("/bank/accounts")
public class BankController extends ControllerApi<BankAccountDto, Object, BankService>{
    public BankController(IServiceApi<BankAccountDto, Object> service) {
        super(service);
        this.logger = LoggerFactory.getLogger(BankController.class);
    }

    @GetMapping
    @Override
    public ResponseEntity<Page<BankAccountDto>> getPage(Pageable pageProp) {
        return super.getPage(pageProp);
    }

    @GetMapping("/find")
    @Override
    public ResponseEntity<BankAccountDto> findObject(int id) {
        return super.findObject(id);
    }

    @PostMapping
    @Override
    public ResponseEntity<BankAccountDto> saveObject(@RequestBody BankAccountDto requestObject) {
        return super.saveObject(requestObject);
    }

    @PutMapping
    @Override
    public ResponseEntity<BankAccountDto> updateObject(@RequestBody BankAccountDto requestObject) {
        return super.updateObject(requestObject);
    }

    @DeleteMapping
    @Override
    public ResponseEntity<?> deleteObject(int id) {
        return super.deleteObject(id);
    }

    @Override
    protected String getEntityName() {
        return "Bank Account";
    }

    @Override
    protected String getEntityPluralName() {
        return "Bank Accounts";
    }
/*@GetMapping
    public ResponseEntity<Page<BankAccountDto>> getBankAccounts(
            @PageableDefault(page = 0,size = 5) Pageable pageable
    )
    {
        logger.info("Get accounts...");
        ResponseEntity<Page<BankAccountDto>> response = ResponseEntity.ok(this.bankService.getBankAccounts(pageable));
        logger.info("Accounts obtained...");
        return response;
    }

    @GetMapping("/find")
    public ResponseEntity<BankAccountDto> getBankAccount(int id)
    {
        logger.info("Find account...");
        BankAccountDto bankAccount = this.bankService.getBankAccount(id);
        if(bankAccount == null) {
            logger.info("Account" + id +" not found");
            throw new ApiRequestException("No account " + id + " exist",HttpStatus.NOT_FOUND);
        }
        logger.info("Account found...");
        return ResponseEntity.ok(bankAccount);
    }

    @PostMapping
    public ResponseEntity<BankAccountDto> saveBankAccount(
            @RequestBody(required = true) BankAccountDto account
    )
    {
        logger.info("Save account...");
        try{
            BankAccountDto accountResponded = this.bankService.saveBankAccount(account);
            if(accountResponded == null)
            {
                logger.warn("Account" + account +" not saved");
                throw new ApiRequestException("Invalid fields", HttpStatus.BAD_REQUEST);
            }
            logger.info("Account saved...");
            return ResponseEntity.ok(accountResponded);
        }catch (RuntimeException e)
        {
            throw new ApiRequestException("Invalid fields", HttpStatus.BAD_REQUEST);
        }

    }

    @PutMapping
    public ResponseEntity<BankAccountDto> updateBankAccount(
            @RequestBody(required = true) BankAccountDto account
    )
    {
        logger.info("Update account...");
        try{
            BankAccountDto accountResponded = this.bankService.updateBankAccount(account);
            if(accountResponded == null)
            {
                logger.warn(account + " has not been updated...");
                throw new ApiRequestException("Invalid fields", HttpStatus.BAD_REQUEST);
            }
            logger.info("Account "+ accountResponded + " updated...");
            return ResponseEntity.ok(accountResponded);
        }catch (RuntimeException e)
        {
            throw new ApiRequestException("Invalid fields", HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping
    public ResponseEntity<?> deleteBankAccount(int id)
    {
        logger.info("Delete account...");
        try {
            this.bankService.deleteBankAccount(id);
        }catch (RuntimeException e)
        {
            throw new ApiRequestException("No account " + id +" exist", HttpStatus.NOT_FOUND);
        }
        logger.info("Account deleted...");
        return ResponseEntity.ok().build();
    }*/
}
