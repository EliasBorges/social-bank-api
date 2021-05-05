package com.social.bank.socialbank.controller;

import com.social.bank.socialbank.controller.request.account.movement.DepositAccountRequest;
import com.social.bank.socialbank.controller.request.account.movement.PaymentAccountRequest;
import com.social.bank.socialbank.controller.request.account.movement.TransferAccountRequest;
import com.social.bank.socialbank.controller.response.movement.ExtractAccountResponse;
import com.social.bank.socialbank.entity.Movement;
import com.social.bank.socialbank.service.MovementService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static org.springframework.data.domain.Sort.Direction.ASC;
import static org.springframework.http.HttpStatus.OK;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/movements")
public class MovementController {
    private static final Integer SIZE_MAX_PAGE = 100;

    private final MovementService service;

    @ResponseStatus(OK)
    @GetMapping(value = "/{idenfifier}/extracts")
    public Page<Movement> getExtract(
            @PathVariable String idenfifier,
            @PageableDefault(sort = "name", direction = ASC, size = 20) Pageable page
    ) {
       // return service.getExtract(idenfifier, page).map(ExtractAccountResponse::fromExtract);
       // return service.getExtract(idenfifier, page);
        return null;
    }

    @ResponseStatus(OK)
    @PutMapping(value = "/deposits/accounts/{idenfifier}")
    public void deposits(
            @PathVariable String idenfifier,
            @Valid @RequestBody DepositAccountRequest request
    ) {
        service.deposits(idenfifier, request);
    }

    @ResponseStatus(OK)
    @PutMapping(value = "transfers/accounts/{idenfifier}")
    public void transfer(
            @PathVariable String idenfifier,
            @Valid @RequestBody TransferAccountRequest request
    ) {
        service.transfer(idenfifier, request);
    }

    @ResponseStatus(OK)
    @PutMapping(value = "payments/accounts/{idenfifier}")
    public void payment(
            @PathVariable String idenfifier,
            @Valid @RequestBody PaymentAccountRequest request
    ) {
        service.payment(idenfifier, request);
    }
}
