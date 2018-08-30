package com.dusk.anonymous;

/**
 * @Package Name : ${PACKAG_NAME}
 * @Author : dongfucai@meituan.com
 * @Creation Date : 2018年05月29日上午11:16
 * @Function : todo
 */
public class AnonymousClass {

    private Runnable r1=new Runnable() {

        @Override
        public void run() {
            System.out.println(1);
        }
    };
    public void method1(){
        Runnable r2=new Runnable() {

            @Override
            public void run() {
                System.out.println(2);
            }
        };
    }

    public static void main(String[] args) {

        Runnable r3=new Runnable() {

            @Override
            public void run() {
                System.out.println(3);
            }
        };
    }

}
