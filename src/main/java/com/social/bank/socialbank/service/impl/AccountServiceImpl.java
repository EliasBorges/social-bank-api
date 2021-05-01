package com.social.bank.socialbank.service.impl;

import static java.lang.String.format;

import com.social.bank.socialbank.controller.request.account.CreateAccountRequest;
import com.social.bank.socialbank.controller.request.account.UpdateAccountRequest;
import com.social.bank.socialbank.controller.response.account.BalenceAccountResponse;
import com.social.bank.socialbank.entity.Account;
import com.social.bank.socialbank.exceptions.DocumentAlreadyExistsException;
import com.social.bank.socialbank.exceptions.NotFoundException;
import com.social.bank.socialbank.repository.AccountRepository;
import com.social.bank.socialbank.service.AccountService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
@Slf4j
public class AccountServiceImpl implements AccountService {

    private final AccountRepository repository;

    public void create(CreateAccountRequest request) {
        if (repository.existsById(request.getIdenfifier())) {
            log.error("Account not created, idenfifier account = {} register", request.getIdenfifier());

            throw new DocumentAlreadyExistsException(
                    format("AccountServiceImpl: create, identifier account = %s register",
                            request.getIdenfifier()));
        }

        log.info("Create account = {}", request);
        Account.create(request, repository);
    }

    public Account getAccount(String idenfifier) {
        return repository.findById(idenfifier).orElseThrow(() -> {
            log.error("Account not found, idenfifier account = {} not found", idenfifier);

            throw new NotFoundException(format("AccountServiceImpl: findById, idenfifier account = %s not found",
                    idenfifier));
        });
    }

    public BalenceAccountResponse getBalance(String idenfifier) {
        return new BalenceAccountResponse(repository.findById(idenfifier).map(Account::getBalance).orElseThrow(() -> {
            log.error("Account not found, idenfifier account = {} not found", idenfifier);

            throw new NotFoundException(format("AccountServiceImpl: findById, idenfifier account = %s not found",
                    idenfifier));
        }));
    }

    public String update(String idenfifier, UpdateAccountRequest request) {
        Account account = repository.findById(idenfifier).orElseThrow(() -> {
            log.error("Account not update, idenfifier account = {} not found", idenfifier);

            throw new NotFoundException(format("AccountServiceImpl: update, idenfifier account = %s not found", idenfifier));
        });

        log.info("Update account, idenfifier = {}, accountBefore = {}, accountAfter = {}",
                idenfifier,
                request,
                account);

        return account.update(request, repository);
    }

    @Override
    public void canceled(String idenfifier) {

    }
}
