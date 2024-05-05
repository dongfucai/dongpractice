package com.wait_and_sleep;

/**
 * @Author dongfucai/1766318593@qq.com
 * @Description //TODO
 * @Date 2022/6/6 下午10:33
 * @Version 1.0
 **/

public class WaitTest {

    public synchronized void checkwait() {

        try {
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("hello world");
    }



}


class Test1 {

    public static void main(String[] args) {

        WaitTest waitTest = new WaitTest();
        waitTest.checkwait();

        // 会一直等待
    }
}