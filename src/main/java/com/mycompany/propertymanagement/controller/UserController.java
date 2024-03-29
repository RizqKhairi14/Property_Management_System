package com.mycompany.propertymanagement.controller;


import com.mycompany.propertymanagement.DTO.PropertyDTO;
import com.mycompany.propertymanagement.DTO.UserDTO;
import com.mycompany.propertymanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("api/v1/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/register")
    public ResponseEntity<UserDTO> register (@Valid @RequestBody UserDTO newUser){

        newUser = userService.register(newUser);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<UserDTO> login (@Valid @RequestBody UserDTO newUser){

        newUser = userService.login(newUser.getOwnerEmail(), newUser.getPassword());
        return new ResponseEntity<>(newUser, HttpStatus.OK);
    }

}
