package com.example.demo.controller;

import com.example.demo.dto.UserDTO;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "api/v1")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/getUsers")
    public List<UserDTO> getUsers(){
        return userService.getAllUsers();
    }


    @GetMapping("/user/{userID}")
    public UserDTO getUserByID(@PathVariable Integer UserID){
     return userService.getUserByID(userID);
    }


    @PostMapping("/addusers")
    public UserDTO saveUser(@RequestBody UserDTO userDTO ) {
        return userService.saveUser(userDTO);

    }
    @PutMapping("/updateusers")
    public UserDTO updateUser (@RequestBody UserDTO userDTO){
        return userService.updateUser(userDTO);
    }

    @DeleteMapping("/deleteusers/{userID}")
    public String deleteUser(@PathVariable Integer userID){
        return userService.deleteUser(userID);
    }

}