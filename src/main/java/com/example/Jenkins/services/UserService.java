package com.example.Jenkins.services;

import com.example.Jenkins.entities.User;

import java.util.List;

public interface UserService {
    public void saveOrUpdate(User user);
    public User findOne(Long id);
    public List<User> findAll();
    public void delete(Long id);

}
