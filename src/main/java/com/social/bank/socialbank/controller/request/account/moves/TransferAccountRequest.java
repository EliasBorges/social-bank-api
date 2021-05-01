package com.social.bank.socialbank.controller.request.account.moves;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class TransferAccountRequest {
    @Positive(message = "{validation.value}")
    private final Double value;

    @NotBlank(message = "{validation.blank}")
    private final String idenfifierAccountOrigin;

    @NotBlank(message = "{validation.blank}")
    private final String idenfifierAccountDestiny;
}
