package com.StockApplication.StockApplication.Entity;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Converter
public class AddressConverter implements AttributeConverter<Address, String> {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    // Convert Address to JSON string before saving to the DB
    @Override
    public String convertToDatabaseColumn(Address address) {
        if (address == null) {
            return null;
        }
        try {
            return objectMapper.writeValueAsString(address);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Error serializing Address", e);
        }
    }

    // Convert JSON string back to Address object when retrieving from DB
    @Override
    public Address convertToEntityAttribute(String dbData) {
        if (dbData == null) {
            return null;
        }
        try {
            return objectMapper.readValue(dbData, Address.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Error deserializing Address", e);
        }
    }
}