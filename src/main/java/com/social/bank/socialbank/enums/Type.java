package com.social.bank.socialbank.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Type {
    PAYMENT("payment"),
    TRANSFER("transfer"),
    DEPOSIT("deposit");

    private final String type;
}
