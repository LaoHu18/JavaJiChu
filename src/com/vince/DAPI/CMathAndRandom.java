package com.vince.DAPI;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * math类和random类
 */
public class CMathAndRandom {
    public static void main(String[] args) {
        System.out.println(Math.PI);            //直接使用，输出π的值
        System.out.println(Math.abs(-10));      //返回绝对值
        System.out.println(Math.random());      //返回带正号的随机值，范围在0到1之间
        System.out.println(Math.round(0.59764));      //返回最接近该参数的整数
        System.out.println(Math.sqrt(2));      //返回参数的平方根
        System.out.println("----------------");


        Random a = new Random();
        System.out.println(a.nextDouble());      //生成随机数
        System.out.println(a.nextInt(5));      //在参数范围内生成随机数

        DateFormat df = new SimpleDateFormat("yyyy年MM月dd日HH:mm:ss SSS");
        String nowdate = df.format(new Date());
        System.out.println(nowdate);
    }
}
