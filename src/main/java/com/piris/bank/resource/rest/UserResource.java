package com.piris.bank.resource.rest;

import com.piris.bank.domain.User;
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

    @GetMapping("{id}")
    public User getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @GetMapping("/test")
    public User testError() {
        throw new RuntimeException("Hello world");
    }

    @DeleteMapping("{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.delete(id);
    }
}
