package com.vince.BObject;

public class Cinterface {
    public static void main(String[] args) {
        BOY boy = new BOY("小明",10);
        boy.sleep();
        boy.run();
        boy.people();
    }
}
//接口的定义及使用
interface Sleep{
    //接口内可定义抽象方法及常量
    public abstract void sleep();  	//	可定义抽象方法，无方法实现
    public static final int NUM = 7;
}

interface Run{
    public abstract void run();
}
//接口之间可实现多继承
interface People extends Sleep,Run{
    public abstract void people();
}

//实现接口的类，关键字：implements
class BOY implements People{
    private String name;
    private int age;
    public BOY(){};
    public BOY(String name,int age){
        this.name = name;
        this.age = age;
    }
    //需将所有接口进行实现
    public void sleep(){
        System.out.println("我叫"+name+"，今年"+age+"岁，我喜欢睡觉");
    }
    public void run(){
        System.out.println("我"+NUM+"天跑四次步");
    }
    public void people(){
        System.out.println("我是个男孩");
    }
}
