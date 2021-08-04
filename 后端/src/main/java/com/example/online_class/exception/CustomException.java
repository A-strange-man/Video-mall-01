package com.example.online_class.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 自定义异常类
 */
@Data
@AllArgsConstructor
public class CustomException extends RuntimeException{

    private Integer code;
    private String msg;
}
