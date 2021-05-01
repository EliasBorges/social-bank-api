package com.social.bank.socialbank.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.social.bank.socialbank.enums.Type;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = {"idenfifier"})
@ToString
public class Moves {
    @Id
    @Column(updatable = false, unique = true, nullable = false)
    private String idenfifier;

    @Column(nullable = true, name = "bar_code")
    private String barCode;

    @Column(nullable = false)
    private LocalDate date;

    @Column(nullable = false)
    private Double amount;

    @Column(nullable = true, name = "idenfifier_account_origin")
    private String idenfifierAccountOrigin;

    @Column(nullable = true, name = "idenfifier_account_destiny")
    private String idenfifierAccountDestiny;

    @ManyToOne
    @JoinColumn(name = "account_id", foreignKey = @ForeignKey(name = "FK_ID_ACCOUNT"))
    @JsonBackReference
    @ToString.Exclude
    private Account account;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Type type;
}
