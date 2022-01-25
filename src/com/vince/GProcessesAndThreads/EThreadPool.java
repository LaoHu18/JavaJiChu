package com.vince.GProcessesAndThreads;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class EThreadPool {
    public static void main(String[] args) {
        //创建线程池：4种方法
        //1、创建一个单线程的线程池（newSingleThreadExecutor），只存在一个线程，若该线程因为异常停止，则会有另一个线程接替执行
//        ExecutorService es = Executors.newSingleThreadExecutor();
//        es.execute(new ThreadRunnable());
//        es.shutdown();

        //2、创建固定大小的线程池（newFixedThreadPool），每次提交一个任务就创建一个线程，直到线程达到线程池的最大大小
        //该固定线程池的大小达到最大值会保持不变，某个线程因为异常而结束，线程池会补上一个新的线程
//        ExecutorService es = Executors.newFixedThreadPool(2);
//        es.execute(new ThreadRunnable());
//        es.execute(new ThreadRunnable());
//        es.shutdown();

        //3、创建一个可缓存的线程池newCachedThreadPool，如果线程池的大小超过处理任务所需的线程，会回收部分空闲的线程
        //线程池的大小依赖于操作系统能够创建的最大线程大小
//        ExecutorService es = Executors.newCachedThreadPool();
//        es.execute(new ThreadRunnable());
//        es.shutdown();

        //4、创建一个无限制大小的线程池
        ScheduledExecutorService es = Executors.newScheduledThreadPool(3);
        es.schedule(new ThreadRunnable(),3000, TimeUnit.MILLISECONDS);      //延时3秒后执行
        es.shutdown();
    }
}

class ThreadRunnable implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName()+"->"+i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}


