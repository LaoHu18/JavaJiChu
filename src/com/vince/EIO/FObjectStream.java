package com.vince.EIO;

import java.io.*;

/**对象流：将Java对象的原始数据类型写出到文件,实现对象的持久存储
 * 序列化：一个对象要想序列化，必须满足两个条件:
 * 1、该类必须实现java.io.Serializable接口，Serializable 是一个标记接口
 *    该类的所有属性必须是可序列化的，如果有一个属性不需要可序列化的，则该属性必须注明是瞬态的，使用transient 关键字修饰
 * 2、写出对象方法
 *
 * 反序列化：将之前使用序列化的原始数据恢复为对象。
 */
public class FObjectStream {
    public static void main(String[] args) {
        Employee em = new Employee("张珊","南京",20);
        File file = new File("D:\\java\\daima\\JiChuZongJie\\src\\com\\vince\\EIO\\FindFile\\File1\\object.txt");
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
            oos.writeObject(em);
            oos.close();
            System.out.println("序列化完成");
        } catch (IOException e) {
            e.printStackTrace();
        }
        //进行反序列化操作
        Employee em1 = null;
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
            em1 = (Employee)ois.readObject();
            ois.close();
            System.out.println(em1.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
class Employee implements Serializable{
    private String name;
    private String address;
    private transient int age;      //此时不可被序列化
    public Employee() {
    }
    public Employee(String name, String address, int age) {
        this.name = name;
        this.address = address;
        this.age = age;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", age=" + age +
                '}';
    }
}