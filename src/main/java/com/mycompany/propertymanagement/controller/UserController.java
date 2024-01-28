package com.mycompany.propertymanagement.controller;


import com.mycompany.propertymanagement.DTO.PropertyDTO;
import com.mycompany.propertymanagement.DTO.UserDTO;
import com.mycompany.propertymanagement.service.UserService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
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

    @ApiOperation(value = "registration", notes = "This method is used by user for account registration")
    @PostMapping("/register")
    public ResponseEntity<UserDTO> register (@ApiParam(
            name = "userDTO / newUser",
            type = "UserDTO",
            value = "user data",
            example = "user information",
            required = true
    ) @Valid @RequestBody UserDTO newUser){

        newUser = userService.register(newUser);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }

    @PostMapping(path = "/login", consumes = {"application/json"}, produces = {"application/json"})
    public ResponseEntity<UserDTO> login (@Valid @RequestBody UserDTO newUser){

        newUser = userService.login(newUser.getOwnerEmail(), newUser.getPassword());
        return new ResponseEntity<>(newUser, HttpStatus.OK);
    }

}
