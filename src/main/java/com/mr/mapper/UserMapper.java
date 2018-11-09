package com.mr.mapper;

import com.mr.model.TMallUserAccount;
import org.apache.ibatis.annotations.Param;

/**
 * Created by  on 2018/11/5.
 */
public interface UserMapper {
    TMallUserAccount checkUserAndPswd(@Param("userName") String userName,@Param("password") String password);

    TMallUserAccount checkYhMch(@Param("userName") String userName);

    void saveUser(TMallUserAccount user);
}
