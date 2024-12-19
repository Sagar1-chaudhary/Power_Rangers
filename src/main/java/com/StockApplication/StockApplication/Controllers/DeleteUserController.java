package com.StockApplication.StockApplication.Controllers;

import com.StockApplication.StockApplication.Constants.ApiConstants;
import com.StockApplication.StockApplication.Services.DeleteUserService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(ApiConstants.API_USERS)
public class DeleteUserController {

    @Autowired
    private DeleteUserService deleteUserService;

    @Operation(method = ApiConstants.DELETE_USER, summary = "Api to delete user by userID")
    @DeleteMapping(ApiConstants.DELETE_USER)
    public ResponseEntity<Object> deleteUserById(@RequestParam Integer userID) {
        return deleteUserService.deleteUserById(userID);
    }
}
