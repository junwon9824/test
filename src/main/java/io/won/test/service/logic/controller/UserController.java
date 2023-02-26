package io.won.test.service.logic.controller;

import io.won.test.service.logic.entity.User;
import io.won.test.service.logic.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor

public class UserController {

    private final UserService userService;

    @PostMapping("/users")
    public String register(@RequestBody User newUser) {
        return userService.register(newUser);

    }


    @GetMapping("/users/{id}")
    public User find(@PathVariable String id) {
        return userService.find(id);
    }


    @GetMapping("/users")
    public List<User> findAll() {
        return userService.findAll();
    }

    @PutMapping("/users") 
    public void modify(@RequestBody User newUser) {
        userService.modify(newUser);

    }


    @DeleteMapping("users/{id}")
    public void remove(@PathVariable String id) {
        userService.remove(id);
    }




}
