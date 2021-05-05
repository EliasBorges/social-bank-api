package com.social.bank.socialbank.service;

import com.social.bank.socialbank.controller.request.account.CreateAccountRequest;
import com.social.bank.socialbank.controller.request.account.UpdateAccountRequest;
import com.social.bank.socialbank.controller.response.account.BalenceAccountResponse;
import com.social.bank.socialbank.entity.Account;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

import static org.springframework.data.domain.Sort.Direction.ASC;

public interface AccountService {
    void create(@Valid @RequestBody CreateAccountRequest request);

    Account getAccount(@PathVariable String idenfifier);

    public Page<Account> getExtract(@PathVariable String idenfifier,
                                    @PageableDefault(sort = "name", direction = ASC, size = 20)
                                            Pageable pag);

    BalenceAccountResponse getBalance(@PathVariable String idenfifier);

    String update(
            @PathVariable String idenfifier,
            @Valid @RequestBody UpdateAccountRequest request);

    void canceled(@PathVariable String idenfifier);
}
