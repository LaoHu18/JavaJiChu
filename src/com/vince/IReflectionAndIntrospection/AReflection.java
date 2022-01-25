package com.vince.IReflectionAndIntrospection;

import org.junit.Test;

import java.lang.reflect.*;
import java.util.Arrays;

/**反射
 * 反射机制是在运行状态中，对于任意一个类，都能知道这个类的所有属性和方法，对于任意的一个对象，都能调用它的方法和属性，
 * 这种动态获取的信息以及动态调用对象方法的功能叫反射
 */

public class AReflection {
    public static void main(String[] args) {
    }

    /**获取Class实例常用的几种方式
     * 1、调用运行时类的属性：.class
     * 2、通过运行时类的对象,调用getClass()
     * 3、调用Class的静态方法：forName(String classPath)
     */
    @Test
    public void test(){
        //方式1：调用运行时类的属性：.class
        Class dogclass1 = Dog.class;

        //方式2：通过运行时类的对象,调用getClass()
        Dog dog = new Dog("小白","白色",7);
        Class dogclass2 = dog.getClass();

        //方式3：调用Class的静态方法：forName(String classPath)
        try {
            Class dogclass = Class.forName("com.vince.IReflectionAndIntrospection");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**使用Class类创建对象的实例化操作
     * 1、无参构造实例化：
     * 2、有参构造实例化：
     */
    @Test
    public void test1(){
        //进行Class类的创建
        Class dogclass = Dog.class;
        //使用无参构造进行实例化
        try {
            Dog dog = (Dog) dogclass.getDeclaredConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace();
        }

        //使用有参构造进行实例化
        Constructor<?>[] constructors = dogclass.getConstructors();         //获取所有的构造方法
        for (int i = 0; i < constructors.length; i++) {             //遍历其构造方法，得到构造方法参数
            System.out.println(constructors[i]);
        }
        try {
            //创建一个指定的构造方法
            Constructor<Dog> constructor = dogclass.getConstructor(String.class, String.class, int.class);
            //进行实例化
            Dog dog = constructor.newInstance("小黑","黑色",7);
        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    /**通过Class类获取相关类的信息
     * 1、获得其属性:getFields()、getDeclaredFields
     * 2、获得其方法
     */
    @Test
    public void test2(){
        //获得其属性
        Class dogclass = Dog.class;
        //获取其公共属性
        Field[] fields = dogclass.getFields();
        System.out.println(Arrays.toString(fields));
        //获取其所有属性
        Field[] declaredFields = dogclass.getDeclaredFields();
        System.out.println(Arrays.toString(declaredFields));
        //获取其属性是公有还是私有
        for (int i = 0; i < declaredFields.length; i++) {
            int modifiers = declaredFields[i].getModifiers();       //获取属性的私有或公有
            System.out.println(Modifier.toString(modifiers)+"->"+declaredFields[i].getType()+"->"+declaredFields[i].getName());

        }
        System.out.println("以上是获取其属性");
        System.out.println(dogclass.getPackageName());      //获取其包名
        System.out.println("---------------");

        //创建一个有实参的构造方法和实例
        try {
            Constructor<Dog> declaredConstructor = dogclass.getConstructor(String.class, String.class, int.class);
            Dog dog = declaredConstructor.newInstance("小黑","黑色",7);
            //获取其公共方法(包括父类方法)
            Method[] methods = dogclass.getMethods();
            for (int i = 0; i < methods.length; i++) {
                System.out.println(methods[i]);
                //调用其公共方法
                if("toString".equals(methods[i].getName())){
                    String str = (String) methods[i].invoke(dog);
                    System.out.println(str);
                }
            }
            System.out.println("-------------------");
            //获取其私有方法
            Method[] declaredMethods = dogclass.getDeclaredMethods();
            for (int i = 0; i < declaredMethods.length; i++) {
                System.out.println(declaredMethods[i]);
                if("test".equals(declaredMethods[i].getName())){
                    declaredMethods[i].setAccessible(true);     //使其私有方法可以被访问（去除修饰符的检查）
                    declaredMethods[i].invoke(dog);         //调用私有方法
                }
            }
        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

    }


}



class Dog{
    private String name;
    private String color;
    private int age;

    public Dog() {
    }

    public Dog(String name, String color, int age) {
        this.name = name;
        this.color = color;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", age=" + age +
                '}';
    }
    private void test(){
        System.out.println("this is private");
    }
}