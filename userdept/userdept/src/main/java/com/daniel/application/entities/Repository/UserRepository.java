package com.daniel.application.entities.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.daniel.application.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{
    
}
