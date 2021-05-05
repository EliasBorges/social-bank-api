package com.social.bank.socialbank.controller.response.account;

import com.social.bank.socialbank.entity.Account;
import com.social.bank.socialbank.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AccountReponse {
    private String name;
    private String description;
    private Double balance;
    private Status status;

    public static AccountReponse fromAccount(Account account) {
        return new AccountReponse(
                account.getName(),
                account.getDescription(),
                account.getBalance(),
                account.getStatus());
    }
}
