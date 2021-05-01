package com.social.bank.socialbank.controller.response.account;

import com.social.bank.socialbank.entity.Moves;
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
    private List<Moves> moveItemList;
    private Double balance;
}
