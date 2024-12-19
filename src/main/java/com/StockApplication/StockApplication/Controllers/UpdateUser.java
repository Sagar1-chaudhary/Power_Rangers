package com.StockApplication.StockApplication.Controllers;

import com.StockApplication.StockApplication.Constants.ApiConstants;
import com.StockApplication.StockApplication.Entity.User;
import com.StockApplication.StockApplication.Services.UpdateUserService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(ApiConstants.API_USERS)
public class UpdateUser {

    @Autowired
    private UpdateUserService updateUserService;

    @Operation(method = ApiConstants.UPDATE_USER, summary = "Api Update User")
    @PutMapping(ApiConstants.UPDATE_USER)
    public ResponseEntity<Object> updateUser(User user) {
        return updateUserService.updateUser(user);
    }
}
