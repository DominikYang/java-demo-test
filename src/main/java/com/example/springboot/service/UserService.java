package com.example.springboot.service;

import com.example.springboot.entity.User;
import com.example.springboot.exception.GlobalException;
import com.example.springboot.vo.LoginVO;
import com.example.springboot.vo.SignupVO;

import javax.validation.Valid;

public interface UserService {

    /**
     * description: 用户登录
     * @author: Wei Yuyang
     * @time: 2020.03.12
     */
    User login(@Valid LoginVO loginVO) throws GlobalException;
    int signup(@Valid SignupVO signupVo) throws GlobalException;
}
