package com.StockApplication.StockApplication.Entity;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class Address implements Serializable {

    private String city;
    private String country;
    private Integer postalCode;
    private String state;
    private String streetAddress;
}
