package com.example.demo.Exception;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ResourceNotFoundException extends RuntimeException{
    
    String fieldName;
    String fieldValue;
    public ResourceNotFoundException(String fieldName, String fieldValue) {
        super("User is not found with this "+fieldName+" : "+fieldValue);
        this.fieldName=fieldName;
        this.fieldValue=fieldValue;
    }
}
