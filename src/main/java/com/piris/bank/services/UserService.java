package com.piris.bank.services;

import com.piris.bank.domain.User;

import java.util.List;

public interface UserService {

    List<User> getAll();

    User save(User user);
}
