package com.vince.BObject;

import java.util.Arrays;

/**
 * 动态数组的概念与创建
 * 动态数组即实现数组的扩容，实现成员的增删改查
 */
//创建相关类的动态管理数组
public class BCatManager {
    //创建类的数组
    private BCat[] cats = null;
    private int count = 0;      //记录数组当前成员下标
    public BCatManager(){}
    public BCatManager(int size){       //有参构造方法定义动态数组的初始长度
        if(size>0){
            cats = new BCat[size];
        }else{
            cats = new BCat[5];
        }
    }
    //添加相应的增删改查方法
    //实现动态数组的扩容,即成员的增加
    public void addcat(BCat cat){
        if(count>=cats.length){
            //扩充算法，分为扩充原来的一半或者扩充原来的一倍
//            int newsize = cats.length*3/2+1;     //此为扩充原来的一半
            int newsize = cats.length*2;
            cats = Arrays.copyOf(cats,newsize);
        }
        cats[count] = cat;
        count++;
    }
    //实现动态数组的删除，即成员的删除
    public void delcat(int id){
        for (int i = 0; i < count; i++) {
            if(id == cats[i].getId()){
               for(int j = i;j<count-1;j++){
                   cats[j] = cats[j+1];
               }
               cats[count-1] =null;
               count = count - 1;
               break;
            }
        }
    }
    //实现动态数组的查询
    public BCat findcat(int id){
        boolean bool = false;
        for (int i = 0; i < count; i++) {
            if (id == cats[i].getId()){
                System.out.println(cats[i].getName()+cats[i].getColor()+cats[i].getAge()+cats[i].getId());
                bool = true;
                return cats[i];
            }
        }if(bool = false){
            System.out.println("未找到相关信息");
        }
        return null;
    }
    //实现动态数组的更改
    public void updatacat(BCat cat){
        BCat findcat = findcat(cat.getId());
        if (findcat!=null) {
            cats[cat.getId()] = cat;
        }
    }
    //实现动态数组的输出
    public void printcat(){
        for (int i = 0; i < count; i++) {
            System.out.println(cats[i].toString());
        }
    }
}
