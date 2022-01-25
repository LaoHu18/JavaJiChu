package com.vince.DAPI;

/**String 类代表字符串操作
 * 特点：1、字符串不变：字符串的值在创建后不能被更改。
 *      2、因为String对象是不可变的，所以它们可以被共享。
 *      3、“abc” 等效于 char[] data={ ‘a’ , ‘b’ , ‘c’ } 。
 */
public class AString {
    public static void main(String[] args) {
        //创建String对象
        String name = new String("小明");     //此段创建了两个对象，堆内常量池中一个，new字符串在堆内又申请了一个
        char[] chars = {'n','h','l','y','h','k'};
        //String的常用方法
        System.out.println(name.charAt(1));     //根据指定下标找到对应字符
        System.out.println(name.toCharArray());     //以字符数组形式返回全部字符串内容
        System.out.println(name.length());          //返回字符串的长度
        System.out.println(name.concat("爱吃水果"));        //将指定的字符串连接到该字符串的末尾
        System.out.println(new String(chars,1,2));      //将指定范围内的字符数组变为字符串，offset：开始位置，count：输出几个字符
        System.out.println(name.startsWith("你"));           //判断是否以指定内容开头
        System.out.println(name.startsWith("明", 1));            //从指定位置判断是否以指定内容开头
        System.out.println(name.endsWith("明"));         //判断是否以指定内容结尾
        System.out.println(name.replace('明','王'));
        System.out.println(name.replace("小明","小王不"));

        //StringBuilder的常用方法
        StringBuilder str = new StringBuilder("hello world,");
        System.out.println(str.append("my name is hu"));        //拼接
        System.out.println(str.insert(0,"test "));      //指定位置插入
        System.out.println(str.delete(2,4));            //包头不包尾式删除
        System.out.println(str.replace(0,4,"HELLO"));       //替换
        System.out.println(str.reverse());  //倒置

        //StringBuffer与StringBuilder的方法是一样的，区别就在于，StringBuilder更高效,但是StringBuffer是线程安全的
    }

}
