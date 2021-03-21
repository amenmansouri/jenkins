package com.example.Jenkins.controllers;


import com.example.Jenkins.entities.User;
import com.example.Jenkins.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(value = "*")
@RestController
@RequestMapping(value = "users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public void saveOrUpdate(@RequestBody User user){
          userService.saveOrUpdate(user);
    }
    @GetMapping(value = "{id}")
    public User findOne(@PathVariable Long id){
        return userService.findOne(id);
    }
    @GetMapping
    public List<User> findAll(){
        return userService.findAll();
    }
    @DeleteMapping(value = "{id}")
    public void delete(@PathVariable Long id){
        userService.delete(id);
    }
}
