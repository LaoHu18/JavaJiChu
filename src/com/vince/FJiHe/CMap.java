package com.vince.FJiHe;

import com.sun.jdi.Value;

import java.security.KeyStore;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**集合框架Map接口
 * 将键映射到值的对象，一个映射不能包含重复的键，每个键只能映射一个值
 * 1、键值对存储一组对象
 * 2、key不能重复，value可以重复
 * 3、具体的实现类：HashMap、Hashtap、TreeMap、LinkedHasMAP
 */
public class CMap {

    public static void main(String[] args) {
        /**HashMap的实现原理
         * 基于哈希表（数组+链表+二叉树（红黑树））实现
         * 默认数组长度为16，默认加载因子是0.75,
         * 数组长度超过75%进行扩充，扩充算法：当前数组容量左移一位，即扩大一倍
         */
        HashMap<Integer,Cat> catHashMap = new HashMap<>();
        catHashMap.put(1,new Cat("小白","白色"));
        catHashMap.put(2,new Cat("小黑","黑色"));
        catHashMap.put(3,new Cat("大黄","黄色"));
        //获取集合中的数量
        System.out.println(catHashMap.size());
        //通过键对其进行相应的输出
        System.out.println(catHashMap.get(2));

        //遍历输出的三种方式
        //1、遍历entry
        Set<Map.Entry<Integer,Cat>> entrySet = catHashMap.entrySet();
        for(Map.Entry<Integer ,Cat> e:entrySet){
            System.out.println(e.getKey()+"->"+e.getValue());
        }

        //2、遍历键
        Set<Integer> keys = catHashMap.keySet();
        for(Integer key:keys){
            System.out.println(key+"->"+catHashMap.get(key));
        }

        //3、遍历值
        Collection<Cat> values = catHashMap.values();
        for(Cat value:values){
            System.out.println(value);
        }

        //4、使用foreach
        catHashMap.forEach((key,cat) -> {System.out.println(key+"->"+cat);});

        /**Hashtable:实现一个哈希表（数组+链表）
         * 面试题：hashmap与hashtable的区别
         * 1、hashmap的默认数组大小是16，hashtable的默认数组大小是11，但加载因子都是0.75
         * 2、hashmap的扩充方式是左移一位即扩大一倍，hashtable的扩充方式是左移一位+1
         * 3、hashtable的线程是安全的，用在多线程访问
         */

        /**LinkedHahMap:是hashmap的子类
         * 由于hashmap不能保证顺序恒久不变，而LinkedHahMap使用双重链表维护元素添加顺序
         */

        /**TreeMap:基于红黑树的navigablemap实现
         *
          */
    }
}
class Cat{
    private String name;
    private String color;

    public Cat() {
    }

    public Cat(String name, String color) {
        this.name = name;
        this.color = color;
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

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}