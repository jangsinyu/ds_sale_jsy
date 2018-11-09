package com.mr.service.impl;

import com.mr.mapper.UserMapper;
import com.mr.model.TMallUserAccount;
import com.mr.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by JangSinyu on 2018/11/5.
 */
@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private UserMapper userMapper;


    public TMallUserAccount checkUserAndPswd(String userName, String password) {
        return userMapper.checkUserAndPswd(userName, password);
    }

    public TMallUserAccount checkYhMch(String userName) {
        return userMapper.checkYhMch(userName);
    }

    public void saveUser(TMallUserAccount user) {
        userMapper.saveUser(user);
    }
}
