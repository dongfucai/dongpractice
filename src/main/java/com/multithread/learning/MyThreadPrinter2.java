package com.multithread.learning;


/**
 * @Package Name : ${PACKAG_NAME}
 * @Author : 1766318593@qq.com
 * @Creation Date : 2018年05月09日下午4:28
 * @Function : todo
 */
public class MyThreadPrinter2 implements Runnable {

    private String name;
    private Object prev;
    private Object self;


    private MyThreadPrinter2(String name, Object prev, Object self){
        this.name = name;
        this.prev = prev;
        this.self = self;
    }

    @Override
    public void run(){
        int count=10;
        while(count>0){
            synchronized (prev){
                synchronized (self){
                    System.out.print(name);
                    count--;
                    self.notify();
                }
                try{
                    prev.wait();
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }
    }


    public static void main(String[] args) {

        Object a = new Object();
        Object b = new Object();
        Object c = new Object();
        MyThreadPrinter2 pa = new MyThreadPrinter2("A", c, a);
        MyThreadPrinter2 pb = new MyThreadPrinter2("B", a, b);
        MyThreadPrinter2 pc = new MyThreadPrinter2("C", b, c);


        new Thread(pa).start();
        try {
            Thread.sleep(100);  //确保按顺序A、B、C执行
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(pb).start();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(pc).start();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
