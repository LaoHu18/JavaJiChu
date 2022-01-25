package com.vince.BObject;

/**
 * 面向对象三大特征之一：封装
 * 封装可以增强代码的安全性，防止外部对类的属性的随意访问
 * 将类的属性私有化，若要访问其属性，通过对应的get或set方法进行访问
 * 封装的步骤：使用 private 关键字来修饰成员变量。对需要访问的成员变量，提供对应的一对 getXxx方法 、 setXxx方法。
 * 使用private关键字后，只能在本类中进行访问
 */
public class BEncapsulation {
    public static void main(String[] args) {
        BCat cat = new BCat("小白","白色",4,1);
        System.out.println(cat.getName());

        BCatManager bCatManager = new BCatManager(3);
        bCatManager.addcat(new BCat("小黑","黑色",4,1));
        bCatManager.addcat(new BCat("小白","白色",3,2));
        bCatManager.addcat(new BCat("小黄","黄色",2,3));
        bCatManager.addcat(new BCat("小灰","灰色",1,4));
        bCatManager.printcat();
        System.out.println("---------------------");
        bCatManager.delcat(3);
        bCatManager.printcat();
        System.out.println("---------------");
        bCatManager.findcat(2);
        bCatManager.updatacat(new BCat("小绿","绿色",8,2));
        bCatManager.printcat();
    }
}
