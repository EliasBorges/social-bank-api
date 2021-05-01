package com.social.bank.socialbank.controller;

import static org.springframework.http.HttpStatus.*;

import com.social.bank.socialbank.controller.request.account.*;
import com.social.bank.socialbank.controller.response.account.BalenceAccountResponse;
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
    @GetMapping(value = "/{idenfifier}/balances")
    public BalenceAccountResponse getBalance(@PathVariable String idenfifier) {
        return service.getBalance(idenfifier);
    }

    @ResponseStatus(OK)
    @PutMapping(value = "/{idenfifier}")
    public String update(
            @PathVariable String idenfifier,
            @Valid @RequestBody UpdateAccountRequest request
    ) {
        return service.update(idenfifier, request).concat(" atualizada com sucesso!");
    }

    @ResponseStatus(OK)
    @DeleteMapping(value = "/{idenfifier}/canceled")
    public void canceled(@PathVariable String idenfifier) {
        service.canceled(idenfifier);
    }
}
