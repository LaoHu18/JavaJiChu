package com.vince.CDataStructure;

import org.junit.Test;

/**
 * java 异常
 * 指的是程序在执行过程中，出现的非正常的情况，最终会导致JVM的非正常停止。
 */
public class CException {
    private static String[] names = {"admin","bin","vince"};
    public static void main(String[] args) {
        /*异常体系：异常的根类是java.lang.Throwable，子类：java.lang.Error与java.lang.Exception
        1、Error:严重错误Error，无法通过处理的错误，只能事先避免，好比绝症。
        2、Exception:表示异常，异常产生后程序员可以通过代码的方式纠正，使程序继续运行，是必须要处理的。
        异常分类：分为编译期异常和运行期异常
         */
        /*异常的处理：五个关键字try、catch、finally、throw、throws*/
        //1、抛出异常：throw
        int[] arrs = {12,56,87};
        System.out.println(getthrow(arrs,3));

        //2、声明异常throws：将问题标识出来，报告给调用者用于表示当前方法不处理异常,而是提醒该方法的调用者来处理异常(抛出异常)

        //3、捕获异常try…catch

        //4、finally代码块：有一些特定的代码无论异常是否发生，都需要执行。
    }
    //抛出异常
    public static int getthrow(int[] arr,int index){
        if(index<0 || index>arr.length-1){
            throw new ArrayIndexOutOfBoundsException("哥们，角标越界了~~~");
        }
        return arr[index];
    }

    //自定义异常测试
    @Test
    public void CustomException(){
        try {
            check("bin");
            System.out.println("注册成功");     //如果没有异常则继续执行此行代码
        } catch (registerException e) {
            e.printStackTrace();
        }
    }
    //判断当前账号是否存在
    public static boolean check(String username)throws registerException{
        for(String name:names){
            if(username.equals(name)){
                throw new registerException(name+"已经被注册了,请使用其他注册名");
            }
        }
        return true;
    }
}

/**自定义异常
 * 自定义一个编译期异常: 自定义类 并继承于java.lang.Exception。
 * 自定义一个运行时期的异常类:自定义类 并继承于java.lang.RuntimeException。
 */
class registerException extends Exception{
    //空参构造
    public registerException() {}

    public registerException(String message) {
        super(message);   //message表示异常提示
    }
}

