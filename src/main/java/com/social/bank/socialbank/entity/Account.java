package com.social.bank.socialbank.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.social.bank.socialbank.enums.Status;
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
    private List<Moves> moveItemList;
}
