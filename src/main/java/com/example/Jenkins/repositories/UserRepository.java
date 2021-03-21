package com.example.Jenkins.repositories;

import com.example.Jenkins.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
