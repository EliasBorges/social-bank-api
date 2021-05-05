package com.social.bank.socialbank.controller.response.movement;

import com.social.bank.socialbank.entity.Movement;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ExtractAccountResponse {
    private List<Movement> movementItemList;

/*    public static List<ExtractAccountResponse>  fromExtract(Movement movement) {

        List<ExtractAccountResponse> movementItemList = ArrayList<>();

        movementItemList.add(Movement(
                movement.getIdenfifier(),
                movement.getBarCode(),
                movement.getDate(),
                movement.getType(),
                movement.getAmount()))

        return movementItemList;
    }*/
}