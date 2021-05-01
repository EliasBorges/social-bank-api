package com.social.bank.socialbank.service.impl;

import com.social.bank.socialbank.controller.request.account.moves.DepositAccountRequest;
import com.social.bank.socialbank.controller.request.account.moves.PaymentAccountRequest;
import com.social.bank.socialbank.controller.request.account.moves.TransferAccountRequest;
import com.social.bank.socialbank.controller.response.movement.ExtractAccountResponse;
import com.social.bank.socialbank.repository.MovementRepository;
import com.social.bank.socialbank.service.MovementService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
@Slf4j
public class MovementServiceImpl implements MovementService {
    private final MovementRepository repository;

    @Override
    public Page<ExtractAccountResponse> getExtract(String idenfifier, Pageable pag) {
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
}
