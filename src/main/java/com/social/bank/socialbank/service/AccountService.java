package com.social.bank.socialbank.service;

import com.social.bank.socialbank.controller.request.account.CreateAccountRequest;
import com.social.bank.socialbank.controller.request.account.UpdateAccountRequest;
import com.social.bank.socialbank.controller.request.account.moves.DepositAccountRequest;
import com.social.bank.socialbank.controller.request.account.moves.PaymentAccountRequest;
import com.social.bank.socialbank.controller.request.account.moves.TransferAccountRequest;
import com.social.bank.socialbank.controller.response.account.ExtractAccountResponse;
import com.social.bank.socialbank.controller.response.account.SaleAccountResponse;
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

    SaleAccountResponse getSale(@PathVariable String idenfifier);

    Page<ExtractAccountResponse> getExtract(
            @PathVariable String idenfifier,
            @PageableDefault(sort = "name", direction = ASC, size = 20) Pageable pag
    );

    String update(
            @PathVariable String idenfifier,
            @Valid @RequestBody UpdateAccountRequest request);

    String deposits(
            @PathVariable String idenfifier,
            @Valid @RequestBody DepositAccountRequest request
    );

    String transfer(
            @PathVariable String idenfifier,
            @Valid @RequestBody TransferAccountRequest request
    );

    String payment(
            @PathVariable String idenfifier,
            @Valid @RequestBody PaymentAccountRequest request
    );

    void canceled(@PathVariable String idenfifier);
}
