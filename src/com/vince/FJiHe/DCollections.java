package com.vince.FJiHe;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**Collections工具类
 * 主要针对collection和map的操作
 */
public class DCollections {
    public static void main(String[] args) {
        List<String> stringList = new ArrayList<>();
        stringList.add("jack");
        stringList.add("tom");
        stringList.add("lily");
        System.out.println(stringList);
        //1、排序操作：
        Collections.reverse(stringList);           //进行反转操作
        System.out.println("这里是反转操作"+stringList);
        Collections.shuffle(stringList);           //进行随机排序
        System.out.println("这里是随机排序"+stringList);
        Collections.sort(stringList);           //进行升序排列
        System.out.println("这里是升序排列"+stringList);
        Collections.swap(stringList,1,2);            //进行指定位置元素交换操作
        System.out.println("这里是位置交换"+stringList);

        //2、查找和替换（针对collection接口）
        System.out.println(Collections.binarySearch(stringList, "lily"));       //查找对应值
        System.out.println(Collections.max(stringList)+"->"+Collections.min(stringList));                    //输出最大值和最小值
        Collections.fill(stringList,"bin");                    //使用指定对象填充
        System.out.println(stringList);
        Collections.replaceAll(stringList,"tom","vince");
        System.out.println(stringList);
    }
}
