package com.vince.GProcessesAndThreads;

import org.junit.Test;

/**
 * join方法与线程的中断
 * join：加入线程，让调用的线程先执行指定时间或执行完毕
 */
public class BInterrupt {
    public static void main(String[] args) {            //这里是主线程
        JoinRunnale joinRunnale = new JoinRunnale();
        Thread thread1 = new Thread(joinRunnale);
        thread1.start();
        for (int i = 0; i < 20; i++) {
            System.out.println(Thread.currentThread().getName() + "->" + i);
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (i == 10) {                  //此时应等待thread1执行完毕后，主线程才开始执行
                try {
                    thread1.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    /**中断线程：
     * 1、用interrupt方法中断线程，设置中断标记,通过抛出异常的方式告知中断某一线程
     * 2、自定义中断标记
     */
    public void interrupt() {            //主线程
        InterruptRunnable interruptRunnable1 = new InterruptRunnable();
        Thread thread1 = new Thread(interruptRunnable1);
        thread1.start();
        for (int i = 0; i < 20; i++) {
            if (i == 10) {
                thread1.interrupt();
            }
            System.out.println(Thread.currentThread().getName() + "->" + i);
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void userinterrupt() {
        UserInterruptRunnable userInterruptRunnable = new UserInterruptRunnable();
        Thread thread1 = new Thread(userInterruptRunnable);
        thread1.start();
        for (int i = 0; i < 20; i++) {
            if (i == 10) {
                userInterruptRunnable.setFlag(false);
            }
            System.out.println(Thread.currentThread().getName() + "->" + i);
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

//用于测试join方法的线程
class JoinRunnale implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println(Thread.currentThread().getName() + "->" + i);            //得到当前线程的名称
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

//用于测试中断第一种方法的线程
class InterruptRunnable implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            if (Thread.interrupted()) {
                break;
            }
            System.out.println(Thread.currentThread().getName() + "->" + i);            //得到当前线程的名称
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
                Thread.currentThread().interrupt();
            }
        }
    }
}

//自定义标记的中断方式
class UserInterruptRunnable implements Runnable {
    private boolean flag = true;
    public UserInterruptRunnable() {
        flag = true;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    @Override
    public void run() {
        int j = 0;
        while (flag) {
            System.out.println(Thread.currentThread().getName() + "->" + j);
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}