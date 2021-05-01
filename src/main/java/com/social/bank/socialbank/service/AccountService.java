package com.social.bank.socialbank.service;

import com.social.bank.socialbank.controller.request.account.CreateAccountRequest;
import com.social.bank.socialbank.controller.request.account.UpdateAccountRequest;
import com.social.bank.socialbank.controller.response.account.SaleAccountResponse;
import com.social.bank.socialbank.entity.Account;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

public interface AccountService {
    void create(@Valid @RequestBody CreateAccountRequest request);

    Account getAccount(@PathVariable String idenfifier);

    SaleAccountResponse getSale(@PathVariable String idenfifier);

    String update(
            @PathVariable String idenfifier,
            @Valid @RequestBody UpdateAccountRequest request);

    void canceled(@PathVariable String idenfifier);
}
