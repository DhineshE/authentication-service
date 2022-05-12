package com.auth.sample.authentication.controller;

import com.auth.sample.authentication.dto.UserRequestDto;
import com.auth.sample.authentication.entity.User;
import com.auth.sample.authentication.exception.UserApplicationException;
import com.auth.sample.authentication.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class UserController {

    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody User user){
        return new ResponseEntity<>(userService.saveUser(user), HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody UserRequestDto userRequestDto)
                    throws UserApplicationException {
        var user= userService.getUserByUserName(userRequestDto.getUsername());
        if(user.getPassword().equals(userRequestDto.getPassword())){
            return new ResponseEntity<>("User Details is Valid",HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<>("User is Invalid",HttpStatus.UNAUTHORIZED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable(value = "id") int userId)
                    throws UserApplicationException {
        return new ResponseEntity<>(userService.deleteUser(userId), HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<User> updateUser(@RequestBody User user){
        return new ResponseEntity<>(userService.updateUser(user), HttpStatus.OK);
    }
}
