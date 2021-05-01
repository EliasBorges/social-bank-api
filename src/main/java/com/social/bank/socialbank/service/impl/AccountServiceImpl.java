package com.social.bank.socialbank.service.impl;

import static java.lang.String.format;

import com.social.bank.socialbank.controller.request.account.CreateAccountRequest;
import com.social.bank.socialbank.controller.request.account.UpdateAccountRequest;
import com.social.bank.socialbank.controller.request.account.moves.DepositAccountRequest;
import com.social.bank.socialbank.controller.request.account.moves.PaymentAccountRequest;
import com.social.bank.socialbank.controller.request.account.moves.TransferAccountRequest;
import com.social.bank.socialbank.controller.response.account.ExtractAccountResponse;
import com.social.bank.socialbank.controller.response.account.SaleAccountResponse;
import com.social.bank.socialbank.entity.Account;
import com.social.bank.socialbank.exceptions.DocumentAlreadyExistsException;
import com.social.bank.socialbank.exceptions.NotFoundException;
import com.social.bank.socialbank.repository.AccountRepository;
import com.social.bank.socialbank.service.AccountService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
@Slf4j
public class AccountServiceImpl implements AccountService {

    private final AccountRepository repository;

    public void create(CreateAccountRequest request) {
        if(repository.existsById(request.getIdenfifier())){
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
            log.error("Account not found, idenfifier customer = {} not found", idenfifier);

            throw new NotFoundException(format("AccountServiceImpl: findById, idenfifier customer = %s not found",
                    idenfifier));
        });
    }

    @Override
    public SaleAccountResponse getSale(String idenfifier) {
        return null;
    }

    @Override
    public Page<ExtractAccountResponse> getExtract(String idenfifier, Pageable pag) {
        return null;
    }

    @Override
    public String update(String idenfifier, UpdateAccountRequest request) {
        return null;
    }

    @Override
    public String deposits(String idenfifier, DepositAccountRequest request) {
        return null;
    }

    @Override
    public String transfer(String idenfifier, TransferAccountRequest request) {
        return null;
    }

    @Override
    public String payment(String idenfifier, PaymentAccountRequest request) {
        return null;
    }

    @Override
    public void canceled(String idenfifier) {

    }
}
