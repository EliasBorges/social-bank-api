package com.social.bank.socialbank.controller;

import static org.springframework.http.HttpStatus.*;
import static org.springframework.data.domain.Sort.Direction.ASC;

import com.social.bank.socialbank.controller.request.account.*;
import com.social.bank.socialbank.controller.request.account.moves.DepositAccountRequest;
import com.social.bank.socialbank.controller.request.account.moves.PaymentAccountRequest;
import com.social.bank.socialbank.controller.request.account.moves.TransferAccountRequest;
import com.social.bank.socialbank.controller.response.account.ExtractAccountResponse;
import com.social.bank.socialbank.controller.response.account.SaleAccountResponse;
import com.social.bank.socialbank.entity.Account;
import com.social.bank.socialbank.service.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/accounts")
public class AccountController {
    private static final Integer SIZE_MAX_PAGE = 100;

    private final AccountService service;

    @ResponseStatus(CREATED)
    @PostMapping
    public void create(@Valid @RequestBody CreateAccountRequest request) { service.create(request); }

    @ResponseStatus(OK)
    @GetMapping(value = "/{idenfifier}")
    public Account getAccount(@PathVariable String idenfifier) {
        return service.getAccount(idenfifier);
    }

    @ResponseStatus(OK)
    @GetMapping(value = "/{idenfifier}/sales")
    public SaleAccountResponse getSale(@PathVariable String idenfifier) {
        return new SaleAccountResponse();
    }

    @ResponseStatus(OK)
    @GetMapping(value = "/{idenfifier}/extracts")
    public Page<ExtractAccountResponse> getExtract(
            @PathVariable String idenfifier,
            @PageableDefault(sort = "name", direction = ASC, size = 20) Pageable pag
    ) {
        return null;
    }


    @ResponseStatus(OK)
    @PutMapping(value = "/{idenfifier}")
    public String update(
            @PathVariable String idenfifier,
            @Valid @RequestBody UpdateAccountRequest request
    ) {
        return null;
    }

    @ResponseStatus(OK)
    @PutMapping(value = "/{idenfifier}/deposits")
    public String deposits(
            @PathVariable String idenfifier,
            @Valid @RequestBody DepositAccountRequest request
    ) {
        return null;
    }

    @ResponseStatus(OK)
    @PutMapping(value = "/{idenfifier}/transfers")
    public String transfer(
            @PathVariable String idenfifier,
            @Valid @RequestBody TransferAccountRequest request
    ) {
        return null;
    }

    @ResponseStatus(OK)
    @PutMapping(value = "/{idenfifier}/payments")
    public String payment(
            @PathVariable String idenfifier,
            @Valid @RequestBody PaymentAccountRequest request
    ) {
        return null;
    }

    @ResponseStatus(OK)
    @DeleteMapping(value = "/{idenfifier}")
    public void canceled(@PathVariable String idenfifier) {

    }
}
