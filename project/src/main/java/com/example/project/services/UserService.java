package com.example.project.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;
import com.example.project.Repository.UserRepository;
import com.example.project.model.User;

@Service
public class UserService {

    @Autowired
    UserRepository ur;

    public User createUser(User user) {
        return ur.save(user);
    }
    public List<User> getDetails()
    {
        return ur.findAll();
    }
    public User getUsername(String username){
        return ur.findById(username).orElse(null);
    }
    public boolean updateDetails(String username,User u)
        {
            if(this.getUsername(username)==null)
            {
                return false;
            }
            try{
                ur.save(u);
            }
            catch(Exception e)
            {
                return false;
            }
            return true;
        }
        public boolean deleteEmployee(String username)
        {
            if(this.getUsername(username) == null)
            {
                return false;
            }
            ur.deleteById(username);
            return true;
        }
}
