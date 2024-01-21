package com.mycompany.propertymanagement.service.impl;

import com.mycompany.propertymanagement.Converter.UserConverter;
import com.mycompany.propertymanagement.DTO.UserDTO;
import com.mycompany.propertymanagement.entity.UserEntity;
import com.mycompany.propertymanagement.exception.BusinessException;
import com.mycompany.propertymanagement.exception.ErrorModel;
import com.mycompany.propertymanagement.repository.UserRepository;
import com.mycompany.propertymanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private UserConverter userConverter;

    @Override
    public UserDTO register(UserDTO userDTO) {

        Optional<UserEntity> optUe = userRepo.findByOwnerEmail(userDTO.getOwnerEmail());
        if (optUe.isPresent()){
            List<ErrorModel> errorModelList = new ArrayList<>();
            ErrorModel errorModel = new ErrorModel();
            errorModel.setCode("EMAIL_ALREADY_EXIST");
            errorModel.setMessage("The Email Which You Use To Register Already Exist");
            errorModelList.add(errorModel);

            throw new BusinessException(errorModelList);
        }

        UserEntity userEntity = userConverter.ConvertDTOtoEntity(userDTO);
        userRepo.save(userEntity);
        userDTO = userConverter.ConvertEntitytoDTO(userEntity);

        return userDTO;
    }

    @Override
    public UserDTO login(String email, String password) {

        UserDTO userDTO = null;
        Optional<UserEntity> optionalUserEntity = userRepo.findByOwnerEmailAndPassword(email, password);
        if (optionalUserEntity.isPresent()){
            userDTO = userConverter.ConvertEntitytoDTO(optionalUserEntity.get());
        }
        else{

            List<ErrorModel> errorModelList = new ArrayList<>();
            ErrorModel errorModel = new ErrorModel();
            errorModel.setCode("INVALID_LOGIN");
            errorModel.setMessage("Incorrect Email or Password");
            errorModelList.add(errorModel);

            throw new BusinessException(errorModelList);

        }

        return userDTO;
    }
}
