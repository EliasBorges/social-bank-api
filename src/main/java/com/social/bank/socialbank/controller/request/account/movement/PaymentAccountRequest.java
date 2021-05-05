package com.social.bank.socialbank.controller.request.account.movement;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class PaymentAccountRequest {

    @NotBlank(message = "{validation.blank}")
    private final String barCode;

    private final LocalDateTime expiration_date;

    @Positive(message = "{validation.value}")
    private final Double value;
}
