package com.auth.sample.authentication.service;

import com.auth.sample.authentication.entity.User;
import com.auth.sample.authentication.exception.UserApplicationException;
import com.auth.sample.authentication.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User getUserById(int userId) throws UserApplicationException {
        var user = userRepository.findById(userId);
        if(user.isEmpty()){
            throw new UserApplicationException("User Not Found","4000");
        }
        return user.get();
    }

    public User saveUser(User user){
        return userRepository.save(user);
    }

    public String deleteUser(int userId) throws UserApplicationException {
        if(userRepository.existsById(userId)){
            userRepository.deleteById(userId);
            return "User Deleted Successfully.";
        }
         else{
             throw new UserApplicationException("User Id Not Found","4000");
        }
    }

    public User updateUser(User user){
        return userRepository.save(user);
    }

    public User getUserByUserName(String username)
                    throws UserApplicationException {
      var user=  userRepository.findByUserName(username);
        if(user.isEmpty()){
            throw new UserApplicationException("UserName Not Found","4000");
        }
        return user.get();
    }
}
