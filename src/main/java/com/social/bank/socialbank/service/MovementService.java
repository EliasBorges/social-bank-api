package com.social.bank.socialbank.service;

import com.social.bank.socialbank.controller.request.account.movement.DepositAccountRequest;
import com.social.bank.socialbank.controller.request.account.movement.PaymentAccountRequest;
import com.social.bank.socialbank.controller.request.account.movement.TransferAccountRequest;
import com.social.bank.socialbank.entity.Movement;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

import static org.springframework.data.domain.Sort.Direction.ASC;

public interface MovementService {
    Page<Movement> getExtract(
            @PathVariable String idenfifier,
            @PageableDefault(sort = "name", direction = ASC, size = 20) Pageable pag
    );

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
