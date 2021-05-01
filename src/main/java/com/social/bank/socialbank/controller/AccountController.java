package com.social.bank.socialbank.controller;

import static org.springframework.http.HttpStatus.*;

import com.social.bank.socialbank.controller.request.account.*;
import com.social.bank.socialbank.controller.response.account.SaleAccountResponse;
import com.social.bank.socialbank.entity.Account;
import com.social.bank.socialbank.service.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/accounts")
public class AccountController {
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
        return service.getSale(idenfifier);
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
    @DeleteMapping(value = "/{idenfifier}")
    public void canceled(@PathVariable String idenfifier) {

    }
}
