package com.example.demo.service;

import com.example.demo.controller.User;
import com.example.demo.dto.UserDTO;
import com.example.demo.entity.user;
import com.example.demo.repo.UserRepo;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Transactional
public class UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ModelMapper modelMapper;

    public UserDTO saveUser(UserDTO userDTO) {
        userRepo.save(modelMapper.map(userDTO, user.class));
        return userDTO;
    }

    public List<UserDTO> getAllUsers() {         //to fetch data (get status)
        List<user> userList = userRepo.findAll();
        return modelMapper.map(userList, new TypeToken<List<UserDTO>>() {
        }.getType());
    }

    public UserDTO updateUser(UserDTO userDTO) {
        userRepo.save(modelMapper.map(userDTO, user.class));
        return userDTO;
    }

    public boolean deleteUser(UserDTO userDTO) {
        userRepo.delete(modelMapper.map(userDTO, user.class));
        return true;
    }

    //user id > user details
    //select * from user where id=2
    public UserDTO getUserByID(String userID){
        user user = userRepo.getUserByID(userID);
        return modelMapper.map(user,UserDTO.class);
    }

    //user id, address > user details
    //select * from user where id=2 and address = "kandy"
    public UserDTO getUserByIDAndAddress(String userID, String address){
        user user = userRepo.getUserByIDAndAddress(userID,address);
        return modelMapper.map(user,UserDTO.class);
    }











}