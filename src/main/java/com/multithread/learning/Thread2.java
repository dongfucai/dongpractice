package com.multithread.learning;

/**
 * @Package Name : ${PACKAG_NAME}
 * @Author : 1766318593@qq.com
 * @Creation Date : 2018年05月09日下午3:08
 * @Function :  实现java.lang.Runnable 接口
 */
public class Thread2 implements Runnable {

    private String name;

    public Thread2(String name){
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(name + "运行  :  " + i);
            try {
                Thread.sleep((int) Math.random() * 10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    public static void main(String[] args) {

        new Thread(new Thread2("C")).start();
        new Thread(new Thread2("D")).start();


        System.out.println("hello world");
    }

}
