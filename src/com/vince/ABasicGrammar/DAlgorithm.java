package com.vince.ABasicGrammar;

import org.junit.Test;

import java.util.Arrays;

/**算法
 * 冒泡排序：N个数字来排序，两两相比小靠前，外层循环N-1，内存循环N-1-i
 * 选择排序
 * 插入排序
 * 二分法查找
 */
public class DAlgorithm {
    @Test
    //冒泡排序
    public void maopao(){
        int[] arrays = {5,9,3,7,6,12,1};
        for (int i = 0; i < arrays.length-1; i++) {
            for (int j = 0;j<arrays.length-1-i;j++){
                if(arrays[j]>arrays[j+1]){
                    int temp = arrays[j];
                    arrays[j] = arrays[j+1];
                    arrays[j+1] =temp;
                }
            }
        }
        System.out.println(Arrays.toString(arrays));
    }
    @Test
    /**选择排序
     * 第一次从arr[0]到arr[n-1]中选取最小值，与arr[0]交换。第二次从arr[1]到arr[n-1]中选取最小值,
     * 与arr[1]交换…第i次从arr[i-1]到arr[n-1]中选取最小值，与arr[i-1]交换…第n-1次从arr[n-2]到arr[n-1]中选取最小值，与arr[i-2]交换。
     * 总共通过n-1次，得到一个按排序从小到大排列的有序序列。
     */
    public void xuanze(){
        int[] arrays = {5,9,3,7,6,12,1};
        for (int i = 0; i < arrays.length-1; i++) {
            int minIndex = i;
            for (int j = i;j<arrays.length;j++){
                if(arrays[minIndex]>arrays[j]){
                    minIndex = j;
                }
                int temp = arrays[i];
                arrays[i] = arrays[minIndex];
                arrays[minIndex] = temp;
            }
        }
        System.out.println(Arrays.toString(arrays));
    }
}
