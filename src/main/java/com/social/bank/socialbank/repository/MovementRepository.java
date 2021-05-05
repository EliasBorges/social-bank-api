package com.social.bank.socialbank.repository;

import com.social.bank.socialbank.entity.Movement;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovementRepository extends JpaRepository<Movement, String> {
    Page<Movement> findAllByAccount(String idenfifier, Pageable page);
}
