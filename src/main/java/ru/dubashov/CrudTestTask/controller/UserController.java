package ru.dubashov.CrudTestTask.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.dubashov.CrudTestTask.model.User;
import ru.dubashov.CrudTestTask.service.UserService;


@RestController
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/create")
    public String createUser(@RequestBody User user) {
        return userService.createUser(user).getId().toString();

    }

    @GetMapping("/get/{id}")
    public ResponseEntity<User> getById(@PathVariable(name = "id") Long id) {
        return new ResponseEntity<>(userService.getById(id), HttpStatus.OK);
    }
}
