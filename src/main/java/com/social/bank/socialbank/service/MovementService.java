package com.social.bank.socialbank.service;

import com.social.bank.socialbank.controller.request.account.movement.DepositAccountRequest;
import com.social.bank.socialbank.controller.request.account.movement.PaymentAccountRequest;
import com.social.bank.socialbank.controller.request.account.movement.TransferAccountRequest;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

public interface MovementService {
    void deposits(
            @PathVariable String idenfifier,
            @Valid @RequestBody DepositAccountRequest request
    );

    void transfer(
            @PathVariable String idenfifier,
            @Valid @RequestBody TransferAccountRequest request
    );

    void payment(
            @PathVariable String idenfifier,
            @Valid @RequestBody PaymentAccountRequest request
    );
}
