package com.mycompany.propertymanagement.service;

import com.mycompany.propertymanagement.DTO.UserDTO;

public interface UserService {

    UserDTO register (UserDTO userDTO);
    UserDTO login (String email, String password);

}
