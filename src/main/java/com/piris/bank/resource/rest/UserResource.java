package com.piris.bank.resource.rest;

import com.piris.bank.domain.Passport;
import com.piris.bank.repository.UserRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class UserResource {

    private final UserRepository userRepository;

    public UserResource(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/")
    public String hello() {
        Passport passport = new Passport();
        passport.setIdentificationNumber("ind 3");
        passport.setPassportID("2 ID1");

        userRepository.save(passport);
        return "Hello, world!";
    }
}
