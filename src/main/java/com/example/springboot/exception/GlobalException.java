package com.example.springboot.exception;

import com.example.springboot.constant.CodeMessage;
import lombok.Getter;

/**
 * @author lgq
 * @date 2020/1/19
 */
@Getter
public class GlobalException extends Exception {

    private static final long serialVersionUID = -3655264493408473309L;

    private CodeMessage codeMessage;

    public GlobalException(CodeMessage codeMessage) {
        super(codeMessage.getMessage());
        this.codeMessage = codeMessage;
    }



}

