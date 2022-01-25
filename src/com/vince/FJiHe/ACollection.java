package com.vince.FJiHe;

import org.junit.Test;

import java.util.*;

/**集合概述：集合是java中提供的一种容器，可以用来存储多个数据。
 * 集合与数组的区别：
 * 1、数组的长度是固定的。集合的长度是可变的。
 * 2、数组中存储的是同一类型的元素，可以存储基本数据类型值。集合存储的都是对象。而且对象的类型可以不一致。
 *
 * 集合三大接口：Collection（List、Set）、Map、Iterator
 */
public class ACollection {
    /**Collection有两个接口：List、Set
     * List 接口:ArrayList、Vector、LinkedList
     * 1、有序的，元素可以重复
     * 2、允许多个null元素
     * 3、具体的实现类：ArrayList  Vector  LinkedList
     * 在实际开发中：我们如何选择List的具体操作类
     * 1、安全问题
     * 2、是否频繁插入删除操作（LinkedList）
     * 3、是否储存后遍历（ArrayList）
     */
    @Test
    public void ArrayListDemo(){
        /**ArrayList
         * 1、实现原理：采用动态对象数组，默认构造方法创建了一个空数组
         * 2、第一次添加元素，扩展容量为10，之后的扩充算法：原来数组大小+原来数组的一半
         * 3、不适合进行插入和删除操作
         * 4、为了防止数组动态扩充次数过多，建议创建ArraayList时指定容量大小
         * 5、线程不安全，建议在单线程时进行使用
         */
        List<String> list = new ArrayList<>();
        list.add("小明");         //添加
        list.add("爱吃");
        list.add("水果");
        int size = list.size();
        for (int i = 0; i < size; i++) {
            System.out.print(list.get(i));      //获取成员
        }
        System.out.println("-------------");
        //判断该集合中是否有此元素
        System.out.println(list.contains("小明"));
        //删除指定位置元素
        list.remove(2);
        System.out.println(list);
        //修改指定下标元素
        list.set(0,"小王");
        System.out.println(list);
        //在指定位置添加
        list.add(2,"香蕉");
        System.out.println(list);
        //返回指定值的下标
        System.out.println(list.indexOf("小王"));
        //转换为数组形式
        String[] str = list.toArray(new String[]{});
        for (String s:str) {
            System.out.println(s);
        }
    }
    @Test
    public void VevtorDemo(){
        /**Vector
         * 1、实现原理：采用动态对象数组，默认构造方法创建了一个容量为10的对象数组
         * 2、扩充的算法：当增量为0时，扩充为原来的倍，当增量不为0时，扩充为原来大小+增量
         * 3、不适合进行插入和删除操作
         * 4、为了防止数组动态扩充次数过多，建议创建Vector时指定容量大小
         * 5、线程安全，适合在多线程访问时使用
         */
        Vector<Integer> vc = new Vector<>();
        vc.add(50);
        vc.add(11);
        for(Integer v:vc) {
            System.out.println(v);
        }
    }
    @Test
    public void LinkedListDemo(){
        /**LinkedList
         *1、实现原理：采用双向的链表结构实现
         *2、适合删除插入操作，性能高
         * 分配内存空间不是必须是连续的；
         * 插入、删除操作很快，只要修改前后指针就OK了，时间复杂度为O(1)；
         * 访问比较慢，必须得从第一个元素开始遍历，时间复杂度为O(n)
         */
        LinkedList<String> linkedList = new LinkedList<>();
        //在链表后进行添加操作
        linkedList.add("你好");
        //在链表头进行添加操作
        linkedList.addFirst("first");
        //在链表尾部进行添加
        linkedList.addLast("end");
        //在指定位置添加
        linkedList.add(2,"世界");
        System.out.println(linkedList);
        //移除链表中元素
        linkedList.remove(3);       //无参数时代表移除第一个元素
        System.out.println(linkedList);
        //根据下标查找元素
        System.out.println(linkedList.get(1));
    }

    /**Set接口
     *1、无序的，不保证顺序
     *2、不允许重复元素
     *具体实现类：HashSet TreeSet LinkedHashSet
     */
    @Test
    public void HashSetDemo(){
        /**HashSet
         * 1、实现原理：基于哈希表（HashMap）实现,JDK1.8哈希表是由数组+链表+红黑树实现的
         * 2、不允许重复，可以有一个null元素
         * 3、不保证顺序永久不变
         * 4、添加元素时把元素作为HashMap的key存储，HashMap的值使用一个固定object对象
         * 5、排除重复元素是通过equals来检查对象是否相同
         * 6、判断两个对象是否相同，先判断两个对象的HashCode是否相同（若相同，不一定是同一个对象，如果不同，则两个对象则一定不是
         * 	同一个对象），如果相同，则还要进行equals判断，如果相同，则两个对象相同，如果不同，则两个对象不同
         * 7、给HashSet中存放自定义类型元素时，需要重写对象中的hashCode和equals方法
         */
        //创建集合对象
        HashSet<AStudent> hashSet = new HashSet<>();
        AStudent student1 = new AStudent("小明",10);
        AStudent student2 = new AStudent("小李",15);
        AStudent student3 = new AStudent("小王",13);
        hashSet.add(student1);
        hashSet.add(student2);
        hashSet.add(student3);
        System.out.println(hashSet);
        //判断两个对象是否相同
        AStudent student4 =new AStudent("小明",10);
        hashSet.add(student4);
        //首先判断其hashcode是否相同
        if(student1.hashCode() == student4.hashCode()){
            if(student1.equals(student4)){
                System.out.println("他们是同一个对象");
            }else{
                System.out.println("hashcode相同，但不是同一个对象");
            }
        }else
            System.out.println("hashcode不同，不是同一个对象");
    }

    @Test
    public void TreeSetDemo(){
        /**TreeSet 是一个有序的集合，它的作用是提供有序的Set集合。
         * TreeSet是基于TreeMap实现的。TreeSet中的元素支持2种排序方式：自然排序或者根据创建TreeSet 时提供的 Comparator 进行排序
         * TreeSet 实现了java.io.Serializable接口，意味着它支持序列化。
         */
        HashSet<String> hashSet = new HashSet<>();
        hashSet.add("abc");
        hashSet.add("ghi");
        hashSet.add("def");
        System.out.println(hashSet);
    }
    //LinkedHashSet则是以链表的方式进行记录

}
class AStudent {
    private String name;
    private int age;

    public AStudent() {
    }

    public AStudent(String name, int age) {
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
        return "AStudent{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AStudent aStudent = (AStudent) o;
        return age == aStudent.age && Objects.equals(name, aStudent.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}

