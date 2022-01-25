package com.vince.NJAVASE_Exemple.service;

import com.vince.NJAVASE_Exemple.bean.User;
import com.vince.NJAVASE_Exemple.ui.BaseClass;
import com.vince.NJAVASE_Exemple.utils.BusinessException;
import com.vince.NJAVASE_Exemple.utils.UserIO;

/**
 * 实现用户注册的实现类:即实现用户数据的存储
 * 实现用户登录的实现类
 */
public class UserServiceImplement extends BaseClass implements UserService{
    @Override
    public User register(User user) throws BusinessException {
        //实现用户数据存储类的创建
        UserIO userIO = new UserIO();
        //将用户数据添加方法的调用
        userIO.add(user);
        //将用户数据写入文件方法的调用
        userIO.writerUser();
        return user;
    }

    @Override
    public User login(User user) throws BusinessException {
        //首先判断传进来的user对象是否为空
        if(user.getUsername() == null){
            throw new BusinessException(getString("username.notnull"));
        }
        if(user.getPassword() == null){
            throw new BusinessException(getString("password.notnull"));
        }
        //实现用户数据存储类的创建
        UserIO userIO = new UserIO();
        //调用用户的用户名和登录密码查找方法
        User byUsernameAndPassword = userIO.findByUsernameAndPassword(user);
        return byUsernameAndPassword;
    }
}
