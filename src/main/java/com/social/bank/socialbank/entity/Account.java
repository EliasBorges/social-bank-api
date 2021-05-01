package com.social.bank.socialbank.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.social.bank.socialbank.controller.request.account.CreateAccountRequest;
import com.social.bank.socialbank.controller.request.account.UpdateAccountRequest;
import com.social.bank.socialbank.controller.request.account.moves.DepositAccountRequest;
import com.social.bank.socialbank.controller.request.account.moves.TransferAccountRequest;
import com.social.bank.socialbank.enums.Status;
import com.social.bank.socialbank.repository.AccountRepository;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = {"idenfifier"})
@ToString
public class Account {
    @Id
    @Column(updatable = false, unique = true, nullable = false)
    private String idenfifier;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private Double balance;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status;

    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
    @JsonManagedReference
    @ToString.Exclude
    private List<Movement> movementItemList;

    public Account(String idenfifier, String name, String description, double balance, String status) {
        this.idenfifier = idenfifier;
        this.name = name;
        this.description = description;
        this.balance = balance;
        this.status = Status.valueOf(status);
    }

    public static void create(CreateAccountRequest request, AccountRepository repository) {
        repository.save(new Account(
                request.getIdenfifier(),
                request.getName(),
                request.getDescription(),
                0.0,
                request.getStatus()
        ));
    }

    public String update(UpdateAccountRequest request, AccountRepository repository) {
        this.name = request.getName();
        this.description = request.getDescription();

        return repository.save(this).idenfifier;
    }

    public void canceled(Account account, AccountRepository repository){
        this.status = Status.CANCELED;

        repository.save(this);
    }

    public void deposit(DepositAccountRequest request, AccountRepository repository) {
        this.balance = this.balance + request.getValue();
        repository.save(this);
    }

    public void addBalance(Double value, AccountRepository repository) {
        this.balance = this.balance + value;
        repository.save(this);
    }

    public void removeBalance(Double value, AccountRepository repository) {
        this.balance = this.balance - value;
        repository.save(this);
    }
}
