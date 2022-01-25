package com.vince.JGenericsAndRegulars;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**泛型
 * 泛型类的创建
 * <T>:参数化类型，在实际使用时才会指定具体类型
 * 泛型只作用于编译期，在编译后会被擦除
 */
public class AGenerics {
    public static void main(String[] args) {
        //泛型的基础使用方法
        Node<String> node1 = new Node<>("这里是字符串式泛型");
        Node<Integer> node2 = new Node<>(5);
        System.out.println(node1);
        System.out.println(node2);
        System.out.println("-----------");

        test(node1);            //通配符测试
        test(node2);            //泛型上限测试

        //调用泛型方法
        String[] array = {"vince","bin","lily","dog"};
        System.out.println(function(array, 1));

        //调用泛型嵌套
        test2();
    }

    //通配符操作：使用通配符操作。可获得不同泛型的get操作，但是不能获得set操作
    public static void test(Node<?> data){
        System.out.println(data.getDate());
    }

    //泛型上限：只能输入该类型父类或继承该父类的子类
    public static void test1(Node<? extends Number> data){
        System.out.println(data.getDate());
    }

    //泛型方法
    public static <T> T function(T[] array,int i){
        return array[i];
    }

    //泛型的嵌套使用
    public static void test2(){
        //使用hashmap
        Map<Integer,String> map = new HashMap<>();
        map.put(1,"小白是");
        map.put(2,"白色的");
        Set<Map.Entry<Integer, String>> entrySet = map.entrySet();
        for(Map.Entry entry:entrySet){
            System.out.println(entry.getKey()+"->"+entry.getValue());
        }
    }
}

//创建泛型类
class Node<T>{
    private T date;

    public Node() {
    }

    public Node(T date) {
        this.date = date;
    }

    public T getDate() {
        return date;
    }

    public void setDate(T date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Node{" +
                "date=" + date +
                '}';
    }
}