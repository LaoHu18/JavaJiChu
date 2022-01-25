package com.vince.GProcessesAndThreads;

/**守护线程与yield
 * 可分为守护线程和用户线程，当运行的唯一线程都是守护线程时，JVM虚拟机会退出
 */
public class CDaemonThreadAndYield {
    public static void main(String[] args) {
        Thread thread = new Thread(new MyDaemonRunnable());
        //线程优先级设置:优先级高可以使得该线程抢占CPU时间片的概率大一点
        thread.setPriority(Thread.MIN_PRIORITY);            //MAX_PRIORITY最大优先级;MIN_PRIORITY最小优先级；NORM_PRIORITY默认优先级
        //将其设置为守护线程
        thread.setDaemon(true);
        thread.start();
        for (int i = 0; i < 20; i++) {
            System.out.println(Thread.currentThread().getName()+"->"+i);
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(thread.isDaemon());      //测试该线程是否是守护线程
    }
}

class MyDaemonRunnable implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println(Thread.currentThread().getName()+"->"+i);
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}