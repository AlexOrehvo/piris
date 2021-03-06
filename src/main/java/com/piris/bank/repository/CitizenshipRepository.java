package com.piris.bank.repository;

import com.piris.bank.domain.Citizenship;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CitizenshipRepository extends JpaRepository<Citizenship, Long> {
}
