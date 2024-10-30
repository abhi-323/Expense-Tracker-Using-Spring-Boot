package com.training.expensetracker.service;

import com.training.expensetracker.exceptions.ResourceAlreadyExistException;
import com.training.expensetracker.exceptions.ResourceNotFoundException;
import com.training.expensetracker.model.User;
import com.training.expensetracker.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User registerUser(User user) throws ResourceAlreadyExistException {
        Optional<User> existingUser = userRepository.findByEmail(user.getEmail());
        if (existingUser.isPresent()) {
            throw new ResourceAlreadyExistException("User", "email", user.getEmail());
        } else {
            return userRepository.save(user);
        }
    }

    public String loginUser(User user) throws ResourceNotFoundException {
        Optional<User> checkUser = userRepository.findByEmail(user.getEmail());
        if (checkUser.isPresent()) {
            User fetchedUser = checkUser.get();
            if(fetchedUser.getPassword().equals(user.getPassword())){
                return "Login Successful";
            }
        } else {
            throw new ResourceNotFoundException("User", "email", user.getEmail());
        }
        return "Password Incorrect";
    }
}
