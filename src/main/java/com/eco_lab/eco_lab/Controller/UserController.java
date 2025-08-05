package com.eco_lab.eco_lab.Controller;

import com.eco_lab.eco_lab.Entity.User;
import com.eco_lab.eco_lab.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    //    Register User
    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody User user) {
        return userService.registerUser(user);
    }

    //    Login User edited the method
    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody User user) {
        return userService.signin(user);
    }
}
