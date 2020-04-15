package com.example.springboot.advice;


import com.example.springboot.constant.CodeMessage;
import com.example.springboot.dto.BaseResult;
import com.example.springboot.exception.GlobalException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author lgq
 * @date 2020/1/19
 */
@RestControllerAdvice
public class GlobalExceptionAdvice {

    @ExceptionHandler(value = Exception.class)
    public BaseResult<String> handlerException(HttpServletRequest request,
                                               Exception ex) {
        if (ex instanceof GlobalException) {
            GlobalException globalException = (GlobalException) ex;
            BaseResult<String> response = new BaseResult<>();
            response.setCode(globalException.getCodeMessage().getCode());
            response.setMsg(globalException.getMessage());
            return response;
        } else {
            return new BaseResult<>(CodeMessage.INTERNAL_SERVER_ERROR.getCode(),
                    CodeMessage.INTERNAL_SERVER_ERROR.getMessage());
        }

    }

    /**
     * 捕获数据校验失败的异常
     * 将校验失败的原因封装入data
     * @param e 字段校验失败的异常
     * @return 值中的data为异常的原因
     */
    @ExceptionHandler(ConstraintViolationException.class)
    public BaseResult<Map<String, String>> handlerException(ConstraintViolationException e){
        Map<String, String> collect=new HashMap<>();
        for (ConstraintViolation<?> constraintViolation : e.getConstraintViolations()) {
            collect.put(constraintViolation.getPropertyPath().toString().split("\\.")[2],constraintViolation.getMessage());
        }
        return new BaseResult<>(CodeMessage.BAD_REQUEST.getCode(),
                CodeMessage.BAD_REQUEST.getMessage(),collect);
    }
}
