package com.piris.bank.resource.rest;

import com.piris.bank.domain.User;
import com.piris.bank.repository.UserRepository;
import com.piris.bank.services.UserService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserResource {

    private UserService userService;

    public UserResource(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getUsers() {
        return userService.getAll();
    }

    @PostMapping
    public User saveUser(@Valid @RequestBody User user) {
        return userService.save(user);
    }

    @PutMapping
    public User updateUser(@Valid @RequestBody User user) {
        return userService.save(user);
    }
}
