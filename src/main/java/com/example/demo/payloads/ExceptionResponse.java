package com.example.demo.payloads;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class ExceptionResponse {
    private Integer Status;
    private String message;

    public ExceptionResponse(Integer status, String message) {
        Status = status;
        this.message = message;
    }
}
