package com.multithread.synch;

/**
 * @Package Name : ${PACKAG_NAME}
 * @Author : 1766318593@qq.com
 * @Creation Date : 2018年05月09日下午5:51
 * @Function : todo
 */

/**
 * 同步线程
 */
class SyncThreadStaticMethod implements Runnable {
    private static int count;

    public SyncThreadStaticMethod() {
        count = 0;
    }

    // 可以比较一下  synchronized 有无的情况 给一个静态的额方法枷锁
    public synchronized static void method() {
        for (int i = 0; i < 5; i ++) {
            try {
                System.out.println(Thread.currentThread().getName() + ":" + (count++));
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    // synchronized 修饰一个类   所有类型一个对象

    public static void method1(){
        synchronized (SyncThreadStaticMethod.class){

            for (int i = 0; i < 5; i ++) {
                try {
                    System.out.println(Thread.currentThread().getName() + ":" + (count++));
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }


    @Override
    public synchronized void run() {
        method();
    }
}

public class SynchStaticMethod {

    /*
    syncThread1和syncThread2是SyncThread的两个对象，但在thread1和thread2并发执行时却保持了线程同步。
    这是因为run中调用了静态方法method，而静态方法是属于类的，所以syncThread1和syncThread2相当于用了同一把锁。这与Demo1是不同的。


     */
    public static void main(String[] args) {
        SyncThreadStaticMethod syncThread1 = new SyncThreadStaticMethod();
        SyncThreadStaticMethod syncThread2 = new SyncThreadStaticMethod();
        Thread thread1 = new Thread(syncThread1, "SyncThread1");
        Thread thread2 = new Thread(syncThread2, "SyncThread2");
        thread1.start();
        thread2.start();

    }

}
