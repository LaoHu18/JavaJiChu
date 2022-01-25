package com.vince.CDataStructure;

/**
 * 简单的递归算法
 */
public class ARecursion {
    public static void main(String[] args) {
        System.out.println(jiechen(5));
    }

    public static int jiechen(int num) {
        if(num == 1){
            return 1;
        }
        return num*jiechen(num-1);
    }
}

