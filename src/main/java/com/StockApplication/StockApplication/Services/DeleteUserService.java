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
public class DeleteUserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private GetUserService getUserService;

    public ResponseEntity<Object> deleteUserById(Integer userID) {
        try {
            if (userID != null) {
                Optional<User> user = userRepository.findById(userID);
                if (user.isPresent()) {
                    UserResponseDTO userResponseDTO = getUserService.mapToDTO(user.get());
                    userRepository.deleteById(userID);
                    return ResponseEntity.status(HttpStatus.OK)
                            .body(userResponseDTO);
                } else {
                    return ResponseEntity.status(HttpStatus.NOT_FOUND)
                            .body("User not found");
                }
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An error occurred: " + e.getMessage());
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body("Invalid user ID");
    }

}