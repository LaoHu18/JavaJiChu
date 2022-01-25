package com.vince.BObject;

/**
 * 类和对象
 * 类：是一组相关属性和行为的集合。可以看成是一类事物的模板，使用事物的属性特征和行为特征来描述该类事物。
 * 对象：是一类事物的具体体现
 * 面向对象有三大特征：封装、继承、多态
 */
public class AClassesAndObjects {
    public static void main(String[] args) {
        AStudent student = new AStudent("小明","男",4);
        //访问类中的方法
        System.out.println(student.toString());
        student.setName("小李");              //访问其set方法
        System.out.println(student.toString());
    }
}

