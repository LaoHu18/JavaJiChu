package com.vince.BObject;

/**面向对象的三大特征之一：多态
 * 是指同一行为，具有多个不同表现形式
 * 父类类型 变量名 = new 子类对象；
 * 变量名.方法名();
 */
public class DPolymorphism {
    public static void main(String[] args) {
        Animal animal = new Animal("dongwu");
        animal.eat();
        //多态的体现：父类类型 变量名 = new 子类对象
        //引用类型转换：向上转型：父类类型 变量名 = new 子类对象
        Animal cat = new Cat();
        cat.setName("小白猫");
        cat.eat();
        //向下转型：子类类型 变量名 = (子类类型) 父类变量名;向上转型过程中，会存在转型异常
        //会使用关键字instanceof
        if(cat instanceof Cat){
            Cat cat1 = (Cat)cat;
            cat1.eat();
        }else if(cat instanceof Dog){
            Dog dog = (Dog) cat;
            dog.eat();
        }
    }
}
class Animal{
    private String name;

    public Animal() {
    }

    public Animal(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void eat(){
        System.out.println("我是一只动物，我吃东西");
    }
}
class Cat extends Animal{
    public void eat(){
        System.out.println("我是一只猫，我吃猫粮");
    }
}
class Dog extends Animal{
    public void eat(){
        System.out.println("我是一只猫，我吃猫粮");
    }
}