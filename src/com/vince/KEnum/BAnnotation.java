package com.vince.KEnum;

import org.junit.Test;

import java.util.zip.Deflater;

/**注解
 * 1、注解是一种元数据形式。即注解是属于java的一种数据类型，和类、接口、数组、枚举类似。
 * 2、注解用来修饰，类、方法、变量、参数、包。
 * 3、注解不会对所修饰的代码产生直接的影响。
 */
@TestAnnotation (name = "胡全安",age = 21)        //注解的应用，有默认值的属性不用赋值
public class BAnnotation {
    public static void main(String[] args) {
        /**元注解：@Retention、@Documented、@Target、@Inherited、@Repeatable 5 种。
         * 元注解是可以注解到注解上的注解，或者说元注解是一种基本注解，但是它能够应用到其它的注解上面。
         * 1、@Retention：解释说明了这个注解的的存活时间。
         *      RetentionPolicy.SOURCE 注解只在源码阶段保留，在编译器进行编译时它将被丢弃忽视。
         *      RetentionPolicy.CLASS 注解只被保留到编译进行的时候，它并不会被加载到 JVM 中。
         *      RetentionPolicy.RUNTIME 注解可以保留到程序运行的时候，它会被加载进入到 JVM 中，所以在程序运行时可以获取到它们。
         * 2、@Documented：顾名思义，这个元注解肯定是和文档有关。它的作用是能够将注解中的元素包含到 Javadoc 中去。
         * 3、@Target：@Target 指定了注解运用的地方。
         * 4、@Inherited：一个超类被 @Inherited 注解过的注解进行注解的话，那么如果它的子类没有被任何注解应用的话，那么这个子类就继承了超类的注解
         * 5、@Repeatable：Repeatable 自然是可重复的意思
         */
        //通过反射获取注解
        boolean hasAnnoation = Student.class.isAnnotationPresent(TestAnnotation.class);     //判断是否应用对应的注解
        System.out.println(hasAnnoation);
        if(hasAnnoation){
            //创建一个TestAnnotation对象
            TestAnnotation testAnnotation = Student.class.getAnnotation(TestAnnotation.class);
            //获取注解内容
            System.out.println("name="+testAnnotation.name());
        }
    }
    @Test
    public void test(){
        /**java预置的注解
         * 1、@Deprecated：这个元素是用来标记过时的元素，比如过时的方法、过时的类、过时的成员变量。
         * 2、@Override：重写父类方法
         * 3、@SuppressWarnings：阻止警告的意思。
         * 4、@SafeVarargs：参数安全类型注解。它的目的是提醒开发者不要用参数做一些不安全的操作,它的存在会阻止编译器产生 unchecked 这样的警告。
         * 5、@FunctionalInterface：函数式接口注解
         */
    }
}

//注解的定义
@interface TestAnnotation{
    //注解的属性:注解的成员变量在注解的定义中以“无形参的方法”形式来声明，其方法名定义了该成员变量的名字，其返回值定义了该成员变量的类型。
    //在使用时，要给其属性赋值
    String name();
    int age();
    int id() default 1;     //使用default可以使其具有默认值
}

//定义一个测试类
@TestAnnotation (name = "胡全安",age = 21)        //注解的应用，有默认值的属性不用赋值
class Student{
    private String name;
    private int age;
    private int id;

    public Student() {
    }

    public Student(String name, int age, int id) {
        this.name = name;
        this.age = age;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", id=" + id +
                '}';
    }
}