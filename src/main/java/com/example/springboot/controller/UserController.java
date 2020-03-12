package com.example.springboot.controller;

import com.example.springboot.entity.User;
import com.example.springboot.exception.GlobalException;
import com.example.springboot.service.UserService;
import com.example.springboot.vo.LoginVO;
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
    @PostMapping("/login")
    public User login(@RequestBody LoginVO loginVO) throws GlobalException {
        System.out.println(loginVO.toString());
        User login = userService.login(loginVO);
        return login;
    }

}
