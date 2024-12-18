package com.StockApplication.StockApplication.Services;

import com.StockApplication.StockApplication.Entity.User;
import com.StockApplication.StockApplication.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UserRegistrationService {

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public ResponseEntity<Object> saveUser(User user) {
            Optional<User> existingEmail = userRepository.findByEmail(user.getEmail());
//            Optional<User> existingUserID = null;
//            if (user.getUserId() != null) {
//                existingUserID = userRepository.findById(user.getUserId());
//            }
            if (existingEmail.isPresent()) {
                return new ResponseEntity<>("Email already exists", HttpStatus.BAD_REQUEST);
            }
//            else if (existingUserID.isPresent()) {
//                return new ResponseEntity<>("User already exists", HttpStatus.BAD_REQUEST);
//            }
            User savedUser = userRepository.save(user);
            return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

}
