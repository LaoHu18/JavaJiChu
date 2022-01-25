package com.vince.NJAVASE_Exemple.ui;

import com.vince.NJAVASE_Exemple.bean.User;
import java.util.ResourceBundle;
import java.util.Scanner;

/**
 * 用于读取配置文件的父类
 */
public abstract class BaseClass {
    protected static Scanner input = new Scanner(System.in);
    protected static User currUser;         //当前用户对象
    //通过ResourceBundle进行资源文件的读取
    private static ResourceBundle r = ResourceBundle.getBundle("com.vince.NJAVASE_Exemple.res.r");          //获取配置文件
    //通过关键字获取其在资源文件中对应的值
    public static String getString(String key){
        return r.getString(key);
    }
    //换行输出
    public static void println(String s){
        System.out.println(s);
    }
    public static void print(String s){
        System.out.print(s);
    }
}
