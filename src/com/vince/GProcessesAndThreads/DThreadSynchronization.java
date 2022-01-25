package com.vince.GProcessesAndThreads;

import org.junit.Test;

import java.util.Scanner;
import java.util.concurrent.locks.ReentrantLock;

/**线程安全与线程同步
 * 线程安全：如果有多个线程在同时运行，而这些线程可能会同时运行这段代码。
 *      程序每次运行结果和单线程运行的结果是一样的，而且其他的变量的值也和预期的是一样的，就是线程安全的。
 * 线程同步：当我们使用多个线程访问同一资源的时候，且多个线程中对资源有写的操作，就容易出现线程安全问题。
 * 同步操作：1、同步代码块  2、同步方法  3、线程同步锁
 * (1)synchronized(要同步的对象){要同步的代码块}
 *（2）同步方法 private synchronized void methed(){要同步的代码块}
 *（3）Lock实现同步（更灵活的同步控制）
 */
public class DThreadSynchronization {
    public static void main(String[] args) {
        /**售票案例：利用线程同步进行抢票
         */
        synchronizedRunnable sy = new synchronizedRunnable();
        Thread thread1 = new Thread(sy);
        Thread thread2 = new Thread(sy);
        thread1.start();
        thread2.start();
    }
}
//线程同步第一种方法：使用synchronized
class synchronizedRunnable implements Runnable{
    private int ticket = 10;
    private Object object = new Object();
    @Override
    public void run() {
        for (int i = 0; i <6 ; i++) {
            synchronized (object){
                if(ticket>0){
                    System.out.println("你想购买的票还剩余："+ticket+"张");
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    ticket--;
                    System.out.println("恭喜您:"+Thread.currentThread().getName()+"，购票成功,还剩余："+ticket+"张");
                }else{
                    System.out.println("对不起，票已卖完");
                }
            }
        }
    }
}

//线程同步第二种方法：private synchronized void methed(){要同步的代码块}
class MethodRunnable implements Runnable{
    private int ticket = 10;
    @Override
    public void run() {
        for(int i = 0;i<10;i++){
            method();
        }
    }
    private synchronized void method(){
        if(ticket>0){
            System.out.println("您购买的票剩余："+ticket+"张");
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            ticket--;
            System.out.println("恭喜您:"+Thread.currentThread().getName()+"，购买成功，还剩余票数："+ticket+"张");
        }else{
            System.out.println("对不起，票已卖完");
        }
    }
}

//线程同步第三种方法：Lock实现同步
class LockRunnable implements Runnable{
    private int ticket = 10;
    ReentrantLock lock = new ReentrantLock();
    @Override
    public void run() {
        for(int i = 0;i<10;i++){
            method1();
        }
    }
    private void method1(){
        lock.lock();        //锁
        try{
            if(ticket>0){
                System.out.println("您购买的票剩余："+ticket+"张");
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                ticket--;
                System.out.println("恭喜您:"+Thread.currentThread().getName()+"，购买成功，还剩余票数："+ticket+"张");
            }else{
                System.out.println("对不起，票已卖完");
            }
        }finally {
            lock.unlock();      //释放锁
        }
    }
}