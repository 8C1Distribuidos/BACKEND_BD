package com.weine.controllers;

import com.weine.model.dtos.BankAccountDto;
import com.weine.services.BankService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller to map the http request of the bank account interface
 * @author Kaleb
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/bank/accounts")
public class BankController {
    Logger logger = LoggerFactory.getLogger(BankController.class);
    private  final BankService bankService;
    @GetMapping()
    public ResponseEntity<Page<BankAccountDto>> getBankAccounts(
            @PageableDefault(page = 0,size = 5) Pageable pageable
    )
    {
        logger.info("Get accounts...");
        ResponseEntity<Page<BankAccountDto>> response = ResponseEntity.ok(this.bankService.getBankAccounts(pageable));
        logger.info("Accounts obtained...");
        return response;
    }
}
