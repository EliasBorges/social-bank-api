package com.social.bank.socialbank.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class InsufficienteFundsException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    private final String message;
}
