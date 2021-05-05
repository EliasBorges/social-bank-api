package com.social.bank.socialbank.service.impl;

import com.social.bank.socialbank.controller.request.account.movement.DepositAccountRequest;
import com.social.bank.socialbank.controller.request.account.movement.PaymentAccountRequest;
import com.social.bank.socialbank.controller.request.account.movement.TransferAccountRequest;
import com.social.bank.socialbank.entity.Account;
import com.social.bank.socialbank.entity.Movement;
import com.social.bank.socialbank.enums.Status;
import com.social.bank.socialbank.exceptions.AccountCanceledException;
import com.social.bank.socialbank.exceptions.InsufficienteFundsException;
import com.social.bank.socialbank.exceptions.NotFoundException;
import com.social.bank.socialbank.repository.AccountRepository;
import com.social.bank.socialbank.repository.MovementRepository;
import com.social.bank.socialbank.service.MovementService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import static java.lang.String.format;

@AllArgsConstructor
@Service
@Slf4j
public class MovementServiceImpl implements MovementService {
    private final MovementRepository repository;

    private final AccountRepository accountRepository;

    public void deposits(String idenfifier, DepositAccountRequest request) {
        Account account = accountRepository.findById(idenfifier).orElseThrow(() -> {
            log.error("Unrealized deposit, idenfifier account = {} not found", idenfifier);

            throw new NotFoundException(format("MovementServiceImpl: deposit, idenfifier account = %s not found", idenfifier));
        });

        validAccountActive(account);

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

        validAccountActive(accountOrign);
        validAccountActive(accountDestiny);

        validAccountFunds(accountOrign, request.getValue());

        accountOrign.removeBalance(request.getValue(), accountRepository);
        accountDestiny.addBalance(request.getValue(), accountRepository);

        Movement.addMovementTransfer(-request.getValue(), repository, accountOrign);
        Movement.addMovementTransfer(request.getValue(), repository, accountDestiny);
    }

    public void payment(String idenfifier, PaymentAccountRequest request) {
        Account account = accountRepository.findById(idenfifier).orElseThrow(() -> {
            log.error("Unrealized payment, idenfifier account = {} not found", idenfifier);

            throw new NotFoundException(format("MovementServiceImpl: payment, idenfifier account = %s not found", idenfifier));
        });

        validAccountActive(account);

        validAccountFunds(account, request.getValue());

        account.removeBalance(request.getValue(), accountRepository);
        Movement.addMovementPayment(request, repository, account);
    }

    public void validAccountFunds(Account accountOrign, Double value) {
        if (accountOrign.getBalance() <= value) {
            log.error("Unrealized transfer, idenfifier account destiny = {} insufficient funds",
                    accountOrign.getIdenfifier());

            throw new InsufficienteFundsException(
                    format("MovementServiceImpl: transfer, idenfifier account destiny = %s insufficient funds",
                            accountOrign.getIdenfifier()));
        }
    }

    public void validAccountActive(Account account) {
        if (account.getStatus() == Status.CANCELED) {
            log.error("Unrealized movement, account = {} status canceled",
                    account);

            throw new AccountCanceledException(
                    format("MovementServiceImpl: movement, idenfifier account = %s insufficient funds",
                            account));
        }
    }
}
