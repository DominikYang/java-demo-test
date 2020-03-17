package com.example.springboot.controller;

import com.example.springboot.annotation.IgnoreResponseAdvice;
import com.example.springboot.dto.SimpleResult;
import com.example.springboot.entity.User;
import com.example.springboot.exception.GlobalException;
import com.example.springboot.service.UserService;
import com.example.springboot.vo.LoginVO;
import com.example.springboot.vo.SignupVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Wei yuyaung
 * @date 2020.03.12 22:33
 */
@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;


    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * description: 用户登录
     * @return:
     * @author: Wei Yuyang
     * @time: 2020.03.12
     */
    @IgnoreResponseAdvice
    @PostMapping("/login")
    public SimpleResult login(@RequestBody LoginVO loginVO) throws GlobalException {
        System.out.println(loginVO.toString());
        User login = userService.login(loginVO);
        if(login != null){
            return new SimpleResult(true);
        }else {
            return new SimpleResult(false);
        }
    }

    /**
     * description: 用户注册
     * @param signupVo
     * @return
     * @throws GlobalException
     */
    @IgnoreResponseAdvice
    @PostMapping("/signup")
    public SimpleResult signup(@RequestBody SignupVo signupVo) throws GlobalException {
        int signup = userService.signup(signupVo);
        if (signup>0){
            return new SimpleResult(true);
        }else {
            return new SimpleResult(false);
        }
    }
}
