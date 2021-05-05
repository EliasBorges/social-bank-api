package com.social.bank.socialbank.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.social.bank.socialbank.controller.request.account.movement.DepositAccountRequest;
import com.social.bank.socialbank.controller.request.account.movement.PaymentAccountRequest;
import com.social.bank.socialbank.enums.Type;
import com.social.bank.socialbank.repository.MovementRepository;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = {"idenfifier"})
@ToString
public class Movement {
    @Id
    @Column(updatable = false, unique = true, nullable = false)
    private String idenfifier;

    @Column(nullable = true, name = "bar_code")
    private String barCode;

    @Column(nullable = false, name = "expiration_date")
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime expirationDate;

    @Column(nullable = false)
    private Double amount;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Type type;

    @ManyToOne
    @JoinColumn(name = "account_id", foreignKey = @ForeignKey(name = "FK_ID_ACCOUNT"))
    @JsonBackReference
    @ToString.Exclude
    private Account account;

    public Movement(String idenfifier, LocalDateTime now, Double value, Type deposit, Account account) {
        this.idenfifier = idenfifier;
        this.expirationDate = now;
        this.amount = value;
        this.type = deposit;
        this.account = account;
    }

    public static void addMovementDeposit(DepositAccountRequest request, MovementRepository repository, Account account){
        repository.save(new Movement(
                UUID.randomUUID().toString(),
                LocalDateTime.now(),
                request.getValue(),
                Type.DEPOSIT,
                account
        ));
    }

    public static void addMovementTransfer(Double valueOperation, MovementRepository repository, Account account){
        repository.save(new Movement(
                UUID.randomUUID().toString(),
                LocalDateTime.now(),
                valueOperation,
                Type.TRANSFER,
                account
        ));
    }

    public static void addMovementPayment(PaymentAccountRequest request, MovementRepository repository, Account account){
        repository.save(new Movement(
                UUID.randomUUID().toString(),
                request.getBarCode(),
                request.getExpiration_date(),
                request.getValue(),
                Type.PAYMENT,
                account
        ));
    }
}
