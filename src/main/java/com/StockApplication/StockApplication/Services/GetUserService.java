package com.StockApplication.StockApplication.Services;

import com.StockApplication.StockApplication.DTO.UserResponseDTO;
import com.StockApplication.StockApplication.Entity.User;
import com.StockApplication.StockApplication.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GetUserService {

    @Autowired
    private UserRepository userRepository;


    public UserResponseDTO mapToDTO(User userEntity){
        UserResponseDTO response = new UserResponseDTO(
                userEntity.getUserId(),
                userEntity.getEmail(),
                userEntity.getFullName(),
                userEntity.getDateOfBirth(),
                userEntity.getGender(),
                userEntity.getUsername(),
                userEntity.getPhoneNumber(),
                userEntity.getAddress()
        );

        return response;
    }
    public ResponseEntity<Object> getUserByID(Integer userId) {
        try {
            if (userId != null) {
                Optional<User> user = userRepository.findById(userId);
                if (user.isPresent()) {
                    User userEntity = user.get();
                    return ResponseEntity.ok(mapToDTO(userEntity));
                } else {
                    return ResponseEntity.status(HttpStatus.NOT_FOUND)
                            .body("User not found");
                }
            } else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body("Invalid user ID");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An error occurred: " + e.getMessage());
        }
    }

    public ResponseEntity<Object> getUsersList() {
        try {
            Iterable<User> users = userRepository.findAll();
            return ResponseEntity.ok(users);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                   .body("An error occurred: " + e.getMessage());
        }
    }
}
