package com.vince.NJAVASE_Exemple.ui;

import com.vince.NJAVASE_Exemple.bean.User;
import com.vince.NJAVASE_Exemple.service.UserService;
import com.vince.NJAVASE_Exemple.service.UserServiceImplement;
import com.vince.NJAVASE_Exemple.utils.BusinessException;

/**
 * 注册界面的创建:
 */
public class RegsiterClass extends BaseClass{
    //注册方法
    public void register()throws BusinessException {
        //请输入注册的用户名
        println(getString("input.username"));
        String username = input.nextLine();
        //请输入注册用户密码
        println(getString("input.password"));
        String password = input.nextLine();
        //初始化一个用户
        User user = new User(username,password);
        //初始化注册实现对象，并调用实现方法，实现用户数据的存储
        UserService userService = new UserServiceImplement();
        userService.register(user);
    }
}
