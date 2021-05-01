package com.social.bank.socialbank.service;

import com.social.bank.socialbank.controller.request.account.moves.DepositAccountRequest;
import com.social.bank.socialbank.controller.request.account.moves.PaymentAccountRequest;
import com.social.bank.socialbank.controller.request.account.moves.TransferAccountRequest;
import com.social.bank.socialbank.controller.response.movement.ExtractAccountResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

import static org.springframework.data.domain.Sort.Direction.ASC;

public interface MovementService {
    Page<ExtractAccountResponse> getExtract(
            @PathVariable String idenfifier,
            @PageableDefault(sort = "name", direction = ASC, size = 20) Pageable pag
    );

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
}
