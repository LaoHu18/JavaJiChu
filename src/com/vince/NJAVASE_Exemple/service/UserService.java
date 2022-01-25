package com.vince.NJAVASE_Exemple.service;

import com.vince.NJAVASE_Exemple.bean.User;
import com.vince.NJAVASE_Exemple.utils.BusinessException;

//实现用户注册和登录的接口
public interface UserService {
    //实现用户注册的方法
    public User register(User user)throws BusinessException;
    //实现用户登录的方法
    public User login(User user)throws BusinessException;
}
