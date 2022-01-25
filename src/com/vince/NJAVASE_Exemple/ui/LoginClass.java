package com.vince.NJAVASE_Exemple.ui;

import com.vince.NJAVASE_Exemple.bean.User;
import com.vince.NJAVASE_Exemple.service.UserService;
import com.vince.NJAVASE_Exemple.service.UserServiceImplement;
import com.vince.NJAVASE_Exemple.utils.BusinessException;

/**
 * 用户登录界面的创建
 */
public class LoginClass extends BaseClass{
    public void login()throws BusinessException {
        //输出请输入用户名
        println(getString("input.username"));
        String username = input.nextLine();
        //输出请输入登录密码
        println(getString("input.password"));
        String password = input.nextLine();
        //创建一个用户对象
        User user = new User(username,password);
        //创建一个用户登录的实现对象
        UserService userService = new UserServiceImplement();
        //调用检验登录的方法，并返回一个对象
        User login = userService.login(user);
        if(login!=null){        //如果不为空，则将该对象赋为当前对象，为空则抛出异常，登录失败
            currUser = login;
        }
        else
            throw new BusinessException(getString("login.error"));
    }
}
