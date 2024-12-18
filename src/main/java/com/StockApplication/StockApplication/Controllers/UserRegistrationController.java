package com.StockApplication.StockApplication.Controllers;

import com.StockApplication.StockApplication.Constants.ApiConstants;
import com.StockApplication.StockApplication.Entity.User;
import com.StockApplication.StockApplication.Services.UserRegistrationService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(ApiConstants.API_USERS)
public class UserRegistrationController {

    @Autowired
    private UserRegistrationService userRegistrationService;

    @Operation(method = ApiConstants.REGISTER_USER, summary = "Api to register user")
    @PostMapping(ApiConstants.REGISTER_USER)
    public ResponseEntity<Object> registration(@RequestBody User user) {
        return userRegistrationService.saveUser(user);
    }
}
