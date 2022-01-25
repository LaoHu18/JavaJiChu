package com.vince.BObject;

/**封装的优化
 * 1、this关键字：
 * this代表所在类的当前对象的引用（地址值），即对象自己的引用。
 * 使用 this 修饰方法中的变量，解决成员变量被隐藏的问题
 * 2、构造方法：
 * 当一个对象被创建时候，构造方法用来初始化该对象，给对象的成员变量赋初始值。
 * 构造方法可以分为有参和无参两种，最好两种都写
 *
 * 标准代码：JavaBean
 * JavaBean 是 Java语言编写类的一种标准规范。符合 JavaBean的类，
 * 要求类必须是具体的和公共的，并且具有无 参数的构造方法，提供用来操作成员变量的 set 和 get 方法。
 */
public class BCat {
    private String name;
    private String color;
    private int age;
    private int id;

    public BCat() {
    }

    public BCat(String name, String color, int age, int id) {
        this.name = name;
        this.color = color;
        this.age = age;
        this.id = id;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "BCat{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", age=" + age +
                ", id=" + id +
                '}';
    }
}
