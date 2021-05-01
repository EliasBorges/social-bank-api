package com.social.bank.socialbank.controller.response.account;

import com.social.bank.socialbank.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AccountResponse {
    private String idenfifier;
    private String name;
    private String description;
    private Double balance;
    private Status status;
}
