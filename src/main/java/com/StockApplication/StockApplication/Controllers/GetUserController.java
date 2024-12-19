package com.StockApplication.StockApplication.Controllers;

import com.StockApplication.StockApplication.Constants.ApiConstants;
import com.StockApplication.StockApplication.Services.GetUserService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(ApiConstants.API_USERS)
public class GetUserController {

    @Autowired
    private GetUserService getUserService;

    @Operation(method = ApiConstants.GET_USER_BY_EMAIL, summary = "Api to get user by email")
    @GetMapping(ApiConstants.GET_USER_BY_EMAIL)
    public ResponseEntity<Object> getEmployeeByEmpCode(@RequestParam String email) {
        ResponseEntity<Object> response = getUserService.getUserByEmail(email);
        return response;
    }

    @Operation(method = ApiConstants.GET_USER_BY_ID, summary = "Api to get user by ID")
    @GetMapping(ApiConstants.GET_USER_BY_ID)
    public ResponseEntity<Object> getEmployeeByEmpCode(@RequestParam Integer userId) {
        ResponseEntity<Object> response = getUserService.getUserByID(userId);
        return response;
    }

    @Operation(method = ApiConstants.GET_ALL_USERS, summary = "Api to fetch all users")
    @GetMapping(ApiConstants.GET_ALL_USERS)
    public ResponseEntity<Object> getUsersList() {
        return getUserService.getUsersList();
    }
}
