package com.malumot.baza.web.rest;

import com.malumot.baza.domain.User;
import com.malumot.baza.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserResource {

    private final UserService userService;

    public UserResource(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity create(@RequestBody User user){
        if (!checkPasswordLength(user.getPassword())){
            return new ResponseEntity("parol uzunligi 4dan kam", HttpStatus.BAD_REQUEST);
        }
        if (userService.checkUserName(user.getUserName())){
            return new ResponseEntity("Bu user oldin ro`yxatdan o`tgan", HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok(userService.create(user));
    }
    private Boolean checkPasswordLength(String password){
        return password.length() >= 4;
    }

}
