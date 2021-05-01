package com.social.bank.socialbank.controller.request.account.moves;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import javax.validation.constraints.Min;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class DepositAccountRequest {
    @Min(value = 1, message = "{validation.value}")
    private final Double amount;
}
