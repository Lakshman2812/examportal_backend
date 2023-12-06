package com.example.demo.payloads;

import com.example.demo.model.User;
import lombok.Data;

import java.util.List;

@Data
public class SuccessResponse {
    private Integer status;
    private User data;

    public SuccessResponse(Integer status, User data) {
        this.status = status;
        this.data = data;
    }
}
