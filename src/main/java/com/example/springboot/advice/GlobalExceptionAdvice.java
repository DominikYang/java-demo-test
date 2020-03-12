package com.example.springboot.advice;


import com.example.springboot.constant.CodeMessage;
import com.example.springboot.dto.BaseResult;
import com.example.springboot.exception.GlobalException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

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

}
