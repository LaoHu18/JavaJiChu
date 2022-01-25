package com.vince.FJiHe;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**集合框架:Iterator迭代
 * 遍历集合的输出方式有：Iterator ListIterator EnumIterator Foreach
 */
public class BIterator {
    public static void main(String[] args) {
        Student student1 = new Student("小明",10);
        Student student2 = new Student("小李",15);
        Student student3 = new Student("小王",13);
        ArrayList<Student> arrayList = new ArrayList<>();
        arrayList.add(student1);
        arrayList.add(student2);
        arrayList.add(student3);

        //使用Iterator的方式进行遍历输出
        Iterator<Student> iterator = arrayList.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println("这里是Iterator遍历输出");

        //使用forEach的方式进行遍历输出
        for(Student stu:arrayList){
            System.out.println(stu);
        }
        System.out.println("这里是forEach输出");

        //直接调用forEach方法
        arrayList.forEach((Student student)->{System.out.println(student);});
    }
}
class Student{
    private String name;
    private int age;

    public Student() {
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
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

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
