package com.social.bank.socialbank.service.impl;

import com.social.bank.socialbank.controller.request.account.moves.DepositAccountRequest;
import com.social.bank.socialbank.controller.request.account.moves.PaymentAccountRequest;
import com.social.bank.socialbank.controller.request.account.moves.TransferAccountRequest;
import com.social.bank.socialbank.controller.response.movement.ExtractAccountResponse;
import com.social.bank.socialbank.entity.Account;
import com.social.bank.socialbank.entity.Movement;
import com.social.bank.socialbank.exceptions.InsufficienteFundsException;
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

        Movement.addMovementDeposit(request, repository, account);
    }

    public void transfer(String idenfifier, TransferAccountRequest request) {
        Account accountOrign = accountRepository.findById(idenfifier).orElseThrow(() -> {
            log.error("Unrealized transfer, idenfifier account orign = {} not found", idenfifier);

            throw new NotFoundException(format("MovementServiceImpl: transfer, idenfifier account orign = %s not found", idenfifier));
        });

        Account accountDestiny = accountRepository.findById(request.getIdenfifierAccountDestiny()).orElseThrow(() -> {
            log.error("Unrealized transfer, idenfifier account destiny = {} not found", idenfifier);

            throw new NotFoundException(format("MovementServiceImpl: transfer, idenfifier account destiny = %s not found", idenfifier));
        });

        if (accountOrign.getBalance() <= request.getValue()) {
            log.error("Unrealized transfer, idenfifier account destiny = {} insufficient funds", idenfifier);

            throw new InsufficienteFundsException(
                    format("MovementServiceImpl: transfer, idenfifier account destiny = %s insufficient funds", idenfifier));
        }

        accountOrign.removeBalance(request.getValue(), accountRepository);
        Movement.addMovementTransfer(- request.getValue(), repository, accountOrign);

        accountDestiny.addBalance(request.getValue(), accountRepository);
        Movement.addMovementTransfer(request.getValue(), repository, accountDestiny);
    }

    @Override
    public void payment(String idenfifier, PaymentAccountRequest request) {
    }
}
