package com.mycompany.propertymanagement.service.impl;

import com.mycompany.propertymanagement.Converter.UserConverter;
import com.mycompany.propertymanagement.DTO.UserDTO;
import com.mycompany.propertymanagement.entity.UserEntity;
import com.mycompany.propertymanagement.repository.UserRepository;
import com.mycompany.propertymanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private UserConverter userConverter;

    @Override
    public UserDTO register(UserDTO userDTO) {

        UserEntity userEntity = userConverter.ConvertDTOtoEntity(userDTO);
        userRepo.save(userEntity);
        userDTO = userConverter.ConvertEntitytoDTO(userEntity);

        return userDTO;
    }

    @Override
    public UserDTO login(String email, String passwaord) {
        return null;
    }
}
