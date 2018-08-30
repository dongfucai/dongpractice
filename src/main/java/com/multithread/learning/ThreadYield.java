package com.multithread.learning;

/*
在java中，每次程序运行至少启动2个线程。一个是main线程，一个是垃圾收集线程。
因为每当使用java命令执行一个类的时候，实际上都会启动一个ＪＶＭ，每一个ｊＶＭ实习在就是在操作系统中启动了一个进程。


 */

/**
 * @Package Name : ${PACKAG_NAME}
 * @Author : 1766318593@qq.com
 * @Creation Date : 2018年05月09日下午3:55
 * @Function :  结论：yield()从未导致线程转到等待/睡眠/阻塞状态。在大多数情况下，yield()将导致线程从运行状态转到可运行状态，但有可能没有效果。可看上面的图。
 */
public class ThreadYield extends Thread {

    public ThreadYield(String name){
        super(name);
    }

    @Override
    public void run(){
        for(int i=1;i<=50;++i){
            System.out.println(" "+ this.getName() + "---" + i);
            // i=30 线程把cpu 时间让掉  其它线程开始执行
//            if (i == 30){
//                this.yield();
//            }

        }
    }

    public static void main(String[] args) {

        ThreadYield yt1 = new ThreadYield("张三");
        ThreadYield yt2 = new ThreadYield("李四");

        System.out.println(yt1.getPriority());

        yt1.setPriority(Thread.MAX_PRIORITY);
        yt2.setPriority(Thread.MIN_PRIORITY);

        yt1.start();
        yt2.start();
    }

}
