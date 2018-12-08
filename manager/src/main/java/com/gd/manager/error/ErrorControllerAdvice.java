package com.gd.manager.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @auther guodong
 * @email https://github.com/guodong94
 * @date 2018/12/9 0:09
 * 统一处理异常
 */
@ControllerAdvice(basePackages = {"com.gd.manager.controller"})
public class ErrorControllerAdvice {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResponseEntity handleException(Exception e){
        Map<String, Object> attr = new HashMap<>();
        String code = e.getMessage();
        ErrorEnum errorEnum = ErrorEnum.getByCode(code);
        attr.put("code",errorEnum.getCode());
        attr.put("message",errorEnum.getMessage());
        attr.put("canRetry",errorEnum.isCanRetry());
        attr.put("type","advice");
        //Assert.isNull(attr,"advice");
        return new ResponseEntity(attr, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
