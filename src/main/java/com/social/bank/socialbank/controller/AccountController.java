package com.social.bank.socialbank.controller;

import com.social.bank.socialbank.config.PageSizeConfig;
import com.social.bank.socialbank.controller.request.account.CreateAccountRequest;
import com.social.bank.socialbank.controller.request.account.UpdateAccountRequest;
import com.social.bank.socialbank.controller.response.account.AccountExtractReponse;
import com.social.bank.socialbank.controller.response.account.AccountReponse;
import com.social.bank.socialbank.controller.response.account.BalenceAccountResponse;
import com.social.bank.socialbank.service.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static org.springframework.data.domain.Sort.Direction.ASC;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/accounts")
public class AccountController {
    private static final Integer SIZE_MAX_PAGE = 100;

    private final AccountService service;

    @ResponseStatus(CREATED)
    @PostMapping
    public void create(@Valid @RequestBody CreateAccountRequest request) {
        service.create(request);
    }

    @ResponseStatus(OK)
    @GetMapping(value = "/{idenfifier}")
    public AccountReponse getAccount(@PathVariable String idenfifier) {
        return AccountReponse.fromAccount(service.getAccount(idenfifier));
    }

    @ResponseStatus(OK)
    @GetMapping(value = "/extracts/{idenfifier}")
    public Page<AccountExtractReponse> getExtract(
            @PathVariable String idenfifier,
            @PageableDefault(sort = "name", direction = ASC, size = 20) Pageable page
    ) {
        PageSizeConfig.validate("AccountController", SIZE_MAX_PAGE, page.getPageSize());

        return service.getExtract(idenfifier, page).map(AccountExtractReponse::fromAccountExtract);
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
