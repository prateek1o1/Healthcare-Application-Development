package com.example.healthcare.controller;
import com.example.healthcare.model.User;
import com.example.healthcare.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

    @RestController
    @RequestMapping("/users")
    public class UserController {


        private final UserService userService;

        @Autowired
        public UserController(UserService userService) {
            this.userService = userService;
        }

        @GetMapping
        public Iterable<User> getUser() throws Throwable {
            return userService.getAllUsers();
        }
    }
