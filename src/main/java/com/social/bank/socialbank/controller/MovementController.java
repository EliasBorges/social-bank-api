package com.social.bank.socialbank.controller;

import com.social.bank.socialbank.controller.request.account.moves.DepositAccountRequest;
import com.social.bank.socialbank.controller.request.account.moves.PaymentAccountRequest;
import com.social.bank.socialbank.controller.request.account.moves.TransferAccountRequest;
import com.social.bank.socialbank.controller.response.movement.ExtractAccountResponse;
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

    @ResponseStatus(OK)
    @GetMapping(value = "/{idenfifier}/extracts")
    public Page<ExtractAccountResponse> getExtract(
            @PathVariable String idenfifier,
            @PageableDefault(sort = "name", direction = ASC, size = 20) Pageable pag
    ) {
        return null;
    }

    @ResponseStatus(OK)
    @PutMapping(value = "/deposits/accounts/{idenfifier}")
    public String deposits(
            @PathVariable String idenfifier,
            @Valid @RequestBody DepositAccountRequest request
    ) {
        return null;
    }

    @ResponseStatus(OK)
    @PutMapping(value = "transfers/accounts/{idenfifier}")
    public String transfer(
            @PathVariable String idenfifier,
            @Valid @RequestBody TransferAccountRequest request
    ) {
        return null;
    }

    @ResponseStatus(OK)
    @PutMapping(value = "payments/accounts/{idenfifier}")
    public String payment(
            @PathVariable String idenfifier,
            @Valid @RequestBody PaymentAccountRequest request
    ) {
        return null;
    }
}
