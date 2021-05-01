package com.social.bank.socialbank.controller.request.account;

import com.social.bank.socialbank.enums.Status;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class CreateAccountRequest {
    @NotBlank(message = "{validation.blank}")
    private final String idenfifier;

    @NotBlank(message = "{validation.blank}")
    private final String name;

    @NotBlank(message = "{validation.blank}")
    private final String description;

    @NotBlank(message = "{validation.blank}")
    private final String status;
}
