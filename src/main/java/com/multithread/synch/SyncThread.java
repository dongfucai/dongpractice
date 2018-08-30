package com.multithread.synch;

/**
 * @Package Name : ${PACKAG_NAME}
 * @Author : 1766318593@qq.com
 * @Creation Date : 2018年05月09日下午5:15
 * @Function :  synchronizd 一种同步锁
 *    1 修饰代码块    { }     作用的对象是调用这个代码块的对象；
 *    2 修饰一个方法          作用的对象是调用这个方法的对象；
 *    3 修饰一个静态方法    起作用方法 整个静态方法    作用是类的所有的对象
 *    4 修饰一个类         （）
 */


public class SyncThread implements Runnable {

    private static int count;

    public SyncThread(){
        count=0;
    }

    public void run(){
        synchronized (this){

            for (int i=0;i<5;++i){

                System.out.println(Thread.currentThread().getName() + ": "+ (count++));
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }

    public int getCount(){
        return count;
    }


    public static void main(String[] args) {

        SyncThread syncThread=new SyncThread();

        Thread t1 = new Thread(syncThread,"syncThread1");
        Thread t2 = new Thread(syncThread,"syncThread2");

        t1.start();
        t2.start();


        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("-----------------------");


        Thread t3 = new Thread(new SyncThread(),"syncThread3");  // 构造函数静态变量 初始化为0了
        Thread t4 = new Thread(new SyncThread(),"syncThread4");

        t3.start();
        t4.start();

    }

}
