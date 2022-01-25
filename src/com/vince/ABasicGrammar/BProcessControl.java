package com.vince.ABasicGrammar;

import org.junit.Test;


/**
 * 流程控制语句：if语句、switch语句、while语句、do while语句、for语句
 * 三目运算符
 */
public class BProcessControl {
    @Test
    public void test(){
        //if语句：if(关系表达式)｛语句体; ｝
        int a = 10;
        if(a==10){
            System.out.println("this is if 语句");
        }else if (a == 20){
            System.out.println("this is else if 语句");
        }else{
            System.out.println("this is else 语句");
        }
    }

    @Test
    public void test1(){
        //switch语句：
//        switch(表达式) {
//            case 常量值1: 语句体1; break;
//            case 常量值2: 语句体2; break;
//            default: 语句体n+1; break;
//        }
        System.out.println("请输入要执行的序号：");
        switch (2){
            case 1: System.out.println("this is 语句1");break;
            case 2: System.out.println("this is 语句2");break;
            case 3: System.out.println("this is 语句3");break;
            default: System.out.println("this is default 语句");break;
        }
    }
    @Test
    public void test2(){
        //while语句：
        // 初始化表达式①
        //while(布尔表达式②){循环体③步进表达式④
        //}
        int a= 1;
        while (a<5){
            a++;
        }
        System.out.println(a);
    }
    @Test
    public void test3(){
        //do while语句
        // 初始化表达式①
        //do{
        //	循环体③
        //	步进表达式④
        //}while(布尔表达式②);
        int a = 1;
        do{
            a++;
        }while (a<2);
        System.out.println(a);
        //do…while循环的特点：无条件执行一次循环体，即使我们将循环条件直接写成false，也依然会循环一次
    }
    @Test
    public void test4(){
        //for语句
        // for(初始化表达式①; 布尔表达式②; 步进表达式④)
        // {循环体③}
        int sum = 0;
        for(int a = 1;a<10;a++){
            sum = sum +a;
        }
        System.out.println(sum);
    }
    @Test
    public void test5(){
        //三目运算符：数据类型 变量名 = 布尔类型表达式？结果1：结果2
        int a = 5;
        int b = a<10?a:10;
        System.out.println(b);
    }
}
