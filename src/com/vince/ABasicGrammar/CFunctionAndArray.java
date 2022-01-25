package com.vince.ABasicGrammar;

import org.junit.Test;

import java.util.Arrays;

/**方法与数组
 */
public class CFunctionAndArray {
    public static void main(String[] args) {

    }
    @Test
    /**
     * 修饰符 返回值类型 方法名(参数列表){
     * 	代码省略...
     * 	return 结果;}
     * 	方法的重载:在类中可以创建对个方法，其方法名可以相同，但具有不同的参数列表和返回值类型，称为方法的重载
     */
    public void Function(){
        System.out.println("this is Fuction");
    }


    //数组
    @Test
    public void arraytest(){
        //数组的定义方法
        //方法一：数据类型[] 数组名字 = new 数组存储的数据类型[长度];
        String[] array1 =new String[5];
        //方法二：数据类型[] 数组名 = new 数据类型[]{元素1,元素2,元素3…};
        int[] array2 = new int[]{1,2,3,4};
        //方法三：数据类型[] 数组名 = {元素1,元素2,元素3…};
        int[] array3 = {6,7,8,9};
        //数组的访问：通过下标索引进行访问
        System.out.println(array2[1]);
        //数组长度
        System.out.println(array3.length);

        //面试题：两个变量指向一个数组
        int[] array4 = array3;
        array4[1] = 10;
        System.out.println(Arrays.toString(array3));

        //数组的遍历
        for (int i = 0; i < array3.length; i++) {
            System.out.println(array3[i]);
        }
    }
    @Test
    public void arraytest1(){
        //获取数组最大值
        int[] arrays = {5,8,4,9,7};
        int temp = 0;
        for (int i = 0; i < arrays.length; i++) {
            if(temp<arrays[i]){
                temp = arrays[i];
            }
        }
        System.out.println(temp);

        //将数组反转
        for(int j =0;j<arrays.length;j++){
            if(j<arrays.length-1-j){
                int temp1 = arrays[j];
                arrays[j] = arrays[arrays.length-1-j];
                arrays[arrays.length-1-j] = temp1;
            }
        }
        System.out.println(Arrays.toString(arrays));

        //Arrays类的使用方法
        //使用二分法查找
        System.out.println("该值的下标为："+Arrays.binarySearch(arrays, 4));
        //数组排序
        Arrays.sort(arrays);
        System.out.println(Arrays.toString(arrays));

    }
}
