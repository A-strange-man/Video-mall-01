package com.example.online_class.model.request;

import lombok.Data;

/**
 * 登陆 request
 */
@Data
public class LoginRequest {
    private String phone;
    private String pwd;
}
