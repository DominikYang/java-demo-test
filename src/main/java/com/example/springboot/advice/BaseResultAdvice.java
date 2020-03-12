package com.example.springboot.advice;


import com.example.springboot.annotation.IgnoreResponseAdvice;
import com.example.springboot.constant.CodeMessage;
import com.example.springboot.dto.BaseResult;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * @author lgq
 * @date 2020/1/19
 */

@RestControllerAdvice
public class BaseResultAdvice implements ResponseBodyAdvice<Object> {

    @Override
    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass) {
        // 判断类或者方法上是否有 IgnoreResponseAdvice 注解
        return !(methodParameter.getDeclaringClass().isAnnotationPresent(IgnoreResponseAdvice.class)
                || (methodParameter.getMethod() != null && methodParameter.getMethod().isAnnotationPresent(IgnoreResponseAdvice.class)));
    }

    @Override
    @SuppressWarnings({"rawtypes","unchecked"})
    public Object beforeBodyWrite(Object o, MethodParameter methodParameter,
                                  MediaType mediaType,
                                  Class<? extends HttpMessageConverter<?>> aClass,
                                  ServerHttpRequest serverHttpRequest,
                                  ServerHttpResponse serverHttpResponse) {
        BaseResult<Object> response = new BaseResult<>(CodeMessage.SUCCESS.getCode(), CodeMessage.SUCCESS.getMessage());
        if (null == o) {
            return response;
        }
        // 如果已经为 BaseResult 则不改变
        else if (o instanceof BaseResult) {
            response =  (BaseResult<Object>)o;
        } else {
            response.setData(o);
        }
        return response;
    }
}
