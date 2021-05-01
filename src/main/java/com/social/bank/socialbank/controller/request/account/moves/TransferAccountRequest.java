package com.social.bank.socialbank.controller.request.account.moves;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class TransferAccountRequest {
    @Min(value = 1, message = "{validation.value}")
    private final Double amount;

    @NotBlank(message = "{validation.blank}")
    private final String idenfifierAccountOrigin;

    @NotBlank(message = "{validation.blank}")
    private final String idenfifierAccountDestiny;
}
