package com.social.bank.socialbank.service.impl;

import com.social.bank.socialbank.controller.request.account.moves.DepositAccountRequest;
import com.social.bank.socialbank.controller.request.account.moves.PaymentAccountRequest;
import com.social.bank.socialbank.controller.request.account.moves.TransferAccountRequest;
import com.social.bank.socialbank.controller.response.movement.ExtractAccountResponse;
import com.social.bank.socialbank.entity.Account;
import com.social.bank.socialbank.exceptions.NotFoundException;
import com.social.bank.socialbank.repository.AccountRepository;
import com.social.bank.socialbank.repository.MovementRepository;
import com.social.bank.socialbank.service.MovementService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import static java.lang.String.format;

@AllArgsConstructor
@Service
@Slf4j
public class MovementServiceImpl implements MovementService {
    private final MovementRepository repository;

    private final AccountRepository accountRepository;

    @Override
    public Page<ExtractAccountResponse> getExtract(String idenfifier, Pageable pag) {
        return null;
    }

    public void deposits(String idenfifier, DepositAccountRequest request) {
        Account account = accountRepository.findById(idenfifier).orElseThrow(() -> {
            log.error("Unrealized deposit, idenfifier account = {} not found", idenfifier);

            throw new NotFoundException(format("MovementServiceImpl: deposit, idenfifier account = %s not found", idenfifier));
        });

        account.deposit(request, accountRepository);
    }

    @Override
    public void transfer(String idenfifier, TransferAccountRequest request) {
    }

    @Override
    public void payment(String idenfifier, PaymentAccountRequest request) {
    }
}
