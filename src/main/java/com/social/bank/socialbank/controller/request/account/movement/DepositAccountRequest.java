package com.social.bank.socialbank.controller.request.account.movement;

import lombok.*;

import javax.validation.constraints.Positive;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class DepositAccountRequest {
    @Positive(message = "{validation.value}")
    private Double value;
}
