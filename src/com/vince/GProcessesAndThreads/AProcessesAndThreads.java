package com.vince.GProcessesAndThreads;

/**进程与线程
 *进程：是指一个内存中运行的应用程序，每个进程都有一个独立的内存空间，一个应用程序可以同时运行多个进程；
 * 进程也是程序的一次执行过程，是系统运行程序的基本单位；系统运行一个程序即是一个进程从创建、运行到消亡的过程。
 *
 * 线程：线程是进程中的一个执行单元，负责当前进程中程序的执行，一个进程中至少有一个线程。
 * 一个进程中是可以有多个线程的，这个应用程序也可以称之为多线程程序。
 *
 * 并发：指两个或多个事件在同一个时间段内发生，处理器只能处理一个任务，轮流执行。
 * 并行：指两个或多个事件在同一时刻发生（同时发生）
 */
public class AProcessesAndThreads {
    public static void main(String[] args) {
        /**线程的基本使用
         *  两种实现方法：
         *  1、继承Thread类
         *  2、实现Runnable接口（推荐使用）
         *
         *  线程的休眠：在当前现成的执行中，以指定的毫秒数暂定，释放时间片
         *  使用sleep函数
         */
        //第一种方式：继承Thread类
        MyThread myThread = new MyThread();
        //第二种方式：实现Runnable接口
        MyRunnable myRunnable = new MyRunnable();
        Thread thread = new Thread(myRunnable);

        myThread.start();           //启动线程
        thread.start();
    }

}

class MyThread extends Thread{
    //第一种方式：继承Thread类
    public void run(){
        for (int i = 0; i < 10; i++) {
            System.out.println("Thread" + i);
            try {
                Thread.sleep(50);           //使当前正在执行的线程以指定的毫秒数暂停，释放CPU时间片
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class MyRunnable implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Runnable"+i);
            try {
                Thread.sleep(50);           //使当前正在执行的线程以指定的毫秒数暂停，释放CPU时间片
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}