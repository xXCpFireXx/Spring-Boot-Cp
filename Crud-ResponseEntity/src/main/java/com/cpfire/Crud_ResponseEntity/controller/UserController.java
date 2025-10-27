package com.cpfire.Crud_ResponseEntity.controller;

import com.cpfire.Crud_ResponseEntity.database.Database;
import com.cpfire.Crud_ResponseEntity.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("users")
public class UserController {

    @GetMapping
    public ResponseEntity<ArrayList<User>> getAll(){
        return new ResponseEntity<>(Database.users,HttpStatus.OK);
    }

    @GetMapping("login")
    public ResponseEntity<User> login(@RequestBody User loginUser){
        for (User userSelected : Database.users){
            if (userSelected.getEmail().equals(loginUser.getEmail())){
                System.out.println("Email Encontrado");

                if (userSelected.getPassword().equals(loginUser.getPassword())){
                    return new ResponseEntity<>(HttpStatus.OK);
                }else {
                    return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
                }
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<User> createUser (@RequestBody User inputUser){
        User newUser = new User();

        newUser.setName(inputUser.getName());
        newUser.setEmail(inputUser.getEmail());
        newUser.setPassword(inputUser.getPassword());

        Database.users.add(newUser);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }
}
