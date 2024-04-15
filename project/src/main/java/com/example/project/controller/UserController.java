package com.example.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;
import com.example.project.model.User;
import com.example.project.services.UserService;

@RestController
public class UserController {
     @Autowired
    UserService us;
    @PostMapping("/login")
    public ResponseEntity<User> add(@RequestBody User u){
        User obj = us.createUser(u);
        return new ResponseEntity<>(obj,HttpStatus.CREATED);
    }
    @GetMapping("/getlogin")
    public ResponseEntity<List<User>> showInfo() {
        return new ResponseEntity<>(us.getDetails(), HttpStatus.OK);
    }
    @PutMapping("/api/user/{username}")
    public ResponseEntity<User> putMethodName(@PathVariable("username") String username, @RequestBody User u) {
        if(us.updateDetails(username,u) == true)
        {
            return new ResponseEntity<>(u,HttpStatus.OK);
        }
        
        return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    }
@DeleteMapping("/api/user/{username}")
    public ResponseEntity<Boolean> delete(@PathVariable("username") String username)
    {
        if(us.deleteEmployee(username) == true)
        {
            return new ResponseEntity<>(true,HttpStatus.OK);
        }
        return new ResponseEntity<>(false,HttpStatus.NOT_FOUND);
    }
}
