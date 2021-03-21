package com.example.Jenkins.services.impl;

import com.example.Jenkins.entities.User;
import com.example.Jenkins.repositories.UserRepository;
import com.example.Jenkins.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public void saveOrUpdate(User user) {
         userRepository.save(user);
    }

    @Override
    public User findOne(Long id) {
        return userRepository.findById(id).orElseThrow(()-> new EntityNotFoundException(new StringBuilder().append("user doesn't exist with id ").append(id).toString()));
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public void delete(Long id) {
      userRepository.deleteById(id);
    }
}
