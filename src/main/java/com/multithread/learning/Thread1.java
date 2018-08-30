package com.multithread.learning;


/**
 *
 */
// java 中实现 多线程

/**
 * 在java中要想实现多线程，有两种手段，一种是继续Thread类，另外一种是实现Runable接口.
 * (其实准确来讲，应该有三种，还有一种是实现Callable接口，并与Future、线程池结合使用，此文这里不讲这个，
 * 有兴趣看这里Java并发编程与技术内幕:Callable、Future、FutureTask、CompletionService )
 */

class Thread1 extends Thread {

    private String name;

    public Thread1(String name){
        this.name=name;
    }

    @Override
    public void run(){

        System.out.println(Thread.currentThread().getId()+ "辅助线程运行");

        for (int i=0;i<5;++i){
            System.out.println(name + "运行 : " + i);

            try {
                sleep((int)Math.random()*59000); //Thread.sleep()方法调用目的是不让当前线程独自霸占该进程所获取的CPU资源，以留出一定时间给其他线程执行的机会。

               // System.out.println(2333333);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

//但是start方法重复调用的话，会出现java.lang.IllegalThreadStateException异常。
    public static void main(String[] args){
        Thread1 m1 = new Thread1("A");
        Thread1 m2 = new Thread1("B");

        System.out.println(Thread.currentThread().getName()+ "主线程开始运行");
        m1.start();
        m2.start();

        try {
            m1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            m2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        System.out.println(Thread.currentThread().getName()+ "主线程运行结束");


    }


}



