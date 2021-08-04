package com.example.online_class.exception;

import com.example.online_class.util.JsonData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 异常处理类
 */
@ControllerAdvice
public class CustomExceptionHandler {

    // 定义日志工具
    private static final Logger log = LoggerFactory.getLogger(CustomExceptionHandler.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public JsonData handle(Exception e) {
        log.error("系统异常-{}", e.getMessage());
        if (e instanceof CustomException) {
            CustomException customException = (CustomException) e;
            return JsonData.buildError(customException.getCode(), customException.getMsg());
        } else {
            return JsonData.buildError("全局异常，未知错误");
        }
    }
}
