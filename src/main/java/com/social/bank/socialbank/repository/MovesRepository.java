package com.social.bank.socialbank.repository;

import com.social.bank.socialbank.entity.Moves;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovesRepository extends JpaRepository<Moves, String> {
}
