package com.example.springboot.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author lgq
 * @date 2020/1/19
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BaseResult<T> implements Serializable {

    private static final long serialVersionUID = 2646280105894424963L;

    private Integer code;
    private String msg;
    private T data;

    public BaseResult(Integer code, String message) {
        this.code = code;
        this.msg = message;
    }

}
