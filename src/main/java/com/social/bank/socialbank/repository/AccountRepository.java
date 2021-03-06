package com.social.bank.socialbank.repository;

import com.social.bank.socialbank.entity.Account;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, String> {
    Page<Account> findAllByIdenfifier(String idenfifier, Pageable page);
}
