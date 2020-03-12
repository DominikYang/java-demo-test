package com.example.springboot.service.impl;

import com.example.springboot.constant.CodeMessage;
import com.example.springboot.dao.UserDao;
import com.example.springboot.entity.User;
import com.example.springboot.entity.UserExample;
import com.example.springboot.exception.GlobalException;
import com.example.springboot.service.UserService;
import com.example.springboot.vo.LoginVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Wei yuyaung
 * @date 2020.03.12 22:33
 */
@Service
public class UserServiceImpl implements UserService {

    private UserDao userDao;

    @SuppressWarnings("all")
    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public User login(LoginVO loginVO) throws GlobalException {
        String userName = loginVO.getUserName();
        UserExample userExample = new UserExample();
        if(userName.length() == 0 || userName == null){
            userExample.createCriteria().andPhoneNumberEqualTo(loginVO.getPhoneNumber()).andPasswordEqualTo(loginVO.getPassword());
            List<User> users = userDao.selectByExample(userExample);
            if(users.size() == 0){
                throw new GlobalException(CodeMessage.USER_NOT_EXIST);
            }
            return users.get(0);
        }else {
            userExample.createCriteria().andUsernameEqualTo(loginVO.getUserName()).andPasswordEqualTo(loginVO.getPassword());
            List<User> users = userDao.selectByExample(userExample);
            if(users.size() == 0){
                throw new GlobalException(CodeMessage.USER_NOT_EXIST);
            }
            return users.get(0);
        }
    }
}