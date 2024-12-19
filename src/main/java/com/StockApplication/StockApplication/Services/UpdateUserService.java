package com.StockApplication.StockApplication.Services;

import com.StockApplication.StockApplication.DTO.UserResponseDTO;
import com.StockApplication.StockApplication.Entity.User;
import com.StockApplication.StockApplication.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;

@Service
public class UpdateUserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private GetUserService getUserService;

    public ResponseEntity<Object> updateUser(User user) {
        try {
            if (user != null && user.getUserId() != null) {
                Optional<User> existingUserOpt = userRepository.findById(user.getUserId());
                if (existingUserOpt.isPresent()) {
                    User existingUser = existingUserOpt.get();

                    existingUser.setFullName(user.getFullName());
                    existingUser.setEmail(user.getEmail());
                    existingUser.setGender(user.getGender());
                    existingUser.setDateOfBirth(user.getDateOfBirth());
                    existingUser.setGender(user.getGender());
                    existingUser.setPhoneNumber(user.getPhoneNumber());
                    existingUser.setUsername(user.getUsername());
                    existingUser.setAddress(user.getAddress());

                    User updatedUser = userRepository.save(existingUser);

                    // Map the updated entity to a DTO (Data Transfer Object)
                    UserResponseDTO userResponseDTO = getUserService.mapToDTO(updatedUser);
                    return ResponseEntity.status(HttpStatus.OK)
                            .body(Map.of(
                                    "message", "User updated successfully!",
                                    "user", userResponseDTO
                            ));
                } else {
                    return ResponseEntity.status(HttpStatus.NOT_FOUND)
                            .body("User not found");
                }
            } else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body("Invalid user data");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An error occurred: " + e.getMessage());
        }
    }

}
