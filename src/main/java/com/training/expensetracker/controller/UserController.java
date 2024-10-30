package com.training.expensetracker.controller;

import com.training.expensetracker.model.User;
import com.training.expensetracker.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/userlogin")
    ResponseEntity<?> loginUser(@RequestBody User user) {
        return new ResponseEntity<>(userService.loginUser(user), HttpStatus.OK);
    }

    @PostMapping("/userregister")
    ResponseEntity<?> registerUser(@RequestBody User user) {
        return new ResponseEntity<>(userService.registerUser(user), HttpStatus.OK);

    }

}
