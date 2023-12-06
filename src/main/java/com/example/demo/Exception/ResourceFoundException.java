package com.example.demo.Exception;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ResourceFoundException extends RuntimeException{

    String fieldName;
    String fieldValue;
    public ResourceFoundException(String fieldName, String fieldValue) {
        super("User already exist with this "+fieldName+" : "+fieldValue);

        this.fieldName=fieldName;
        this.fieldValue=fieldValue;
    }
}
