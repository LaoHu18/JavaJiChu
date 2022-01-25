package com.vince.NJAVASE_Exemple.utils;

import com.vince.NJAVASE_Exemple.bean.User;
import com.vince.NJAVASE_Exemple.ui.BaseClass;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 用户存储的工具类
 */
public class UserIO extends BaseClass {
    private static List<User> users = new ArrayList<>();        //创建用户集合
    private static final String USER_FILE = "user.obj";     //创建用于存储用户数据的文件名
    //写入用户列表
    public boolean writerUser()throws BusinessException{
        try {
            //创建用户数据的写入流
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(USER_FILE));
            oos.writeObject(users);
            oos.close();
        } catch (IOException e) {
            throw new BusinessException(getString("io.write.error"));
        }
        return true;
    }
    //读取用户列表
    public boolean readerUser()throws BusinessException{
        try {
            //创建用户数据的读取流
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(USER_FILE));
            users = (List<User>) ois.readObject();
            ois.close();
        } catch (IOException | ClassNotFoundException e) {
            throw new BusinessException(getString("io.read.error"));
        }
        return true;
    }
    //定义用户的ID
    public void add(User user){
        user.setId(users.size()+1);
        users.add(user);
    }
    //对用户进行查找
    public User findByUsernameAndPassword(User user)throws BusinessException{
        //首先读取用户列表
        readerUser();
        //利用for循环对比系统内是否有该对象，并返回该对象
        for (int i = 0; i < users.size(); i++) {
            if(user.getUsername().equals(users.get(i).getUsername()) && user.getPassword().equals(users.get(i).getPassword())){
                return users.get(i);
            }
        }
        return null;
    }
}
