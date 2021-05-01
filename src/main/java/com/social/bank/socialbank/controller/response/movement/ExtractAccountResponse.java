package com.social.bank.socialbank.controller.response.movement;

import com.social.bank.socialbank.entity.Movement;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ExtractAccountResponse {
    private String idenfifier;
    private String name;
    private List<Movement> movementItemList;
    private Double balance;
}
