package com.StockApplication.StockApplication.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddressResponseDTO {

    private String street;
    private String city;
    private String country;
    private String state;
    private String postalCode;

    public AddressResponseDTO(String city, String country, Integer postalCode, String state, String streetAddress) {
        this.city = city;
        this.country = country;
        this.state = state;
        this.postalCode = postalCode.toString();
        this.street = streetAddress;
    }
}
