package com.StockApplication.StockApplication.DTO;

import com.StockApplication.StockApplication.Entity.Address;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserResponseDTO {

    private Integer userId;
    private String email;
    private String fullName;
    private String dateOfBirth;
    private String gender;
    private String username;
    private String phoneNumber;
    private AddressResponseDTO address;

    public UserResponseDTO(Integer userId, String email, String fullName, String dateOfBirth,
                        String gender, String username, String phoneNumber, Address address) {
        this.userId = userId;
        this.email = email;
        this.fullName = fullName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.username = username;
        this.phoneNumber = phoneNumber;

        if (address != null) {
            this.address = new AddressResponseDTO(
                    address.getCity(),
                    address.getCountry(),
                    address.getPostalCode(),
                    address.getState(),
                    address.getStreetAddress()
            );
        }
    }
}
