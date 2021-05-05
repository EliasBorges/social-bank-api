package com.social.bank.socialbank.controller.response.account;

import com.social.bank.socialbank.entity.Account;
import com.social.bank.socialbank.entity.Movement;
import com.social.bank.socialbank.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AccountExtractReponse {
    private String name;
    private String description;
    private Double balance;
    private Status status;
    private List<Movement> movementItemList;

    public static AccountExtractReponse fromAccountExtract(Account account) {
        return new AccountExtractReponse(
                account.getName(),
                account.getDescription(),
                account.getBalance(),
                account.getStatus(),
                account.getMovementItemList());
    }
}
