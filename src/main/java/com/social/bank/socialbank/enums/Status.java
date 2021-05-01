package com.social.bank.socialbank.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Status {
    ACTIVE("active"),
    CANCELED("canceled");

    private final String status;
}
