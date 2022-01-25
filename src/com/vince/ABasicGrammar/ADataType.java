package com.vince.ABasicGrammar;

import org.junit.Test;

/**
 * 总结常见的几种数据类型
 * 字节型：byte  1个字节
 * 短整型：short  2个字节
 * 整型：int 4个字节
 * 长整型：long  8个字节
 * 字符型：char  2个字节
 * 单精度：float 4个字节
 * 双精度：double  8个字节
 * 布尔型：boolean
 */
public class ADataType {
    public static void main(String[] args) {
        byte bytes = 1;
        short shorts = 2;
        int ints = 3;
        long longs = 5555;
        char chars = '你';
        float floats = 3.120222f;
        double doubles = 5.2485684;
        boolean bool = true;
    }
    @Test
    public void test(){
        //数据类型的自动转换原则：将取值范围小的数据类型运算时会自动转换为大的数据类型
        //转换顺序：byte、short、char‐‐>int‐‐>long‐‐>float‐‐>double
        byte a = 1;
        int b = 2;
//        byte c = a + b;   //若定义c为byte类型，则会报错
        int c = a+b;
        System.out.println(c);
    }
    @Test
    public void test1(){
        //数据类型的强制转换：数据类型 变量名 = （数据类型）被转数据值
        //浮点转成整数，直接取消小数点，可能造成数据损失精度。
        //int 强制转成 short 砍掉2个字节，可能造成数据丢失
        float floats = 3.1415926f;
        int a = (int)floats;
        System.out.println(a);
    }

}
