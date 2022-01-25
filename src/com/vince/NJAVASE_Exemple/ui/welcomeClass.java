package com.vince.NJAVASE_Exemple.ui;

import com.vince.NJAVASE_Exemple.utils.BusinessException;

/**
 * 初始界面的创建
 */
public class welcomeClass extends BaseClass {
    //开始运行方法
    public void start() {
        //输出欢迎使用《衣服超市自助购物系统》
        println(getString("info.welcome"));
        boolean flag = true;
        while (flag) {
            //输出1、登录 2、注册   请选择：
            println(getString("info.login.reg"));
            println(getString("info.selet"));
            //记录选择
            String select = input.nextLine();
            switch (select) {
                case "1":
                    try {
                        //创建一个登录界面的初始对象
                        LoginClass loginClass = new LoginClass();
                        //登录界面调用登录方法
                        loginClass.login();
                        //输出登录成功
                        println(getString("login.success"));
                        flag = false;
                    }catch (BusinessException e){
                        //若未登陆成功，抛出异常，打印登录失败
                        println(e.getMessage());
                    }
                    break;
                case "2":           //注册方案的实现
                    try {
                        //创建一个注册界面对象
                        RegsiterClass regsiterClass = new RegsiterClass();
                        //注册界面对象调用注册方法
                        regsiterClass.register();
                        //输出注册成功
                        println(getString("reg.success"));
                        flag = false;
                    } catch (BusinessException e) {
                        //若注册未成功，则抛出异常：打印注册失败
                        throw new BusinessException(getString("reg.error"));
                    }
                    break;
                default:
                    println(getString("input.error"));
                    break;
            }
            HomeClass homeClass = new HomeClass();
            homeClass.show();
        }
    }
}
