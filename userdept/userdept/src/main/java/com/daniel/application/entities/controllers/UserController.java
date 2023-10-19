package com.daniel.application.entities.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.daniel.application.entities.User;
import com.daniel.application.entities.Repository.UserRepository;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserRepository repository;
    
    @GetMapping
    public List<User> findAll(){
      List<User> result =  repository.findAll();

      return result;
    }


    @GetMapping(value = "/{id}")
    public User findById(@PathVariable Long id){
      User result =  repository.findById(id).get();
      return result;
    }

     @PostMapping
    public User insert(@RequestBody User user){
      User result =  repository.save(user);
      return result;
    }

    @PatchMapping(value = "/{id}")
    public User partitialUpdate(@RequestBody User userreq, @PathVariable(value = "id") Long  id ){
           
        User user = repository.findById(id).get();
        user.setEmail(userreq.getEmail());
            return user;
    }

}
