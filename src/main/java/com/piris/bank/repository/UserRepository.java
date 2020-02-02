package com.piris.bank.repository;

import com.piris.bank.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

@org.springframework.stereotype.Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
