package com.mr.service;

import com.mr.model.TMallUserAccount;

/**
 * Created by JangSinyu on 2018/11/5.
 */
public interface LoginService {

    TMallUserAccount checkUserAndPswd(String userName, String password);

    TMallUserAccount checkYhMch(String userName);

    void saveUser(TMallUserAccount user);
}
