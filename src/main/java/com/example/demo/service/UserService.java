package com.example.demo.service;

import com.example.demo.dto.UserDTO;
import com.example.demo.model.User;
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
    private  UserRepo userRepo;
    @Autowired
    private  ModelMapper modelMapper;
    public List<UserDTO> getAllUsers(){
        List<User>userList=userRepo.findAll();
        return modelMapper.map(userList,new TypeToken<List<UserDTO>>(){}.getType());
    }


    public  UserDTO saveUser(UserDTO userDTO) {
        userRepo.save(modelMapper.map(userDTO, User.class));
        return userDTO;
    }
    public UserDTO updateUser(UserDTO userDTO){
        userRepo.save(modelMapper.map(userDTO,User.class));
        return userDTO;

    }

    public  String deleteUser(Integer userID){
      //  userRepo.delete (modelMapper.map(userDTO,User.class));
        userRepo.deleteAllById(userID);
        return "user deleted";
    }

      public UserDTO getUserByID (Integer userID){
        User user =  userRepo.getUserBy(userID)
                return modelMapper.map(user,UserDTO.class);
      }
}