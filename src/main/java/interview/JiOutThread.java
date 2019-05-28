package interview;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @Package Name : ${PACKAG_NAME}
 * @Author : dongfucai@meituan.com
 * @Creation Date : 2019年02月24日上午10:27
 * @Function : todo
 */
public class JiOutThread {

    private int num = 1;
    private volatile boolean flag = true;
    private ReentrantLock lock = new ReentrantLock();

    public JiOutThread() {
        JiThead jiThread = new JiThead();
        OutThread outThread =  new OutThread();
        jiThread.start();
        outThread.start();
    }
    private class JiThead extends Thread {
        @Override
        public void run() {
            while (num < 100) {
                if (flag) {
                    lock.lock();
                    System.out.println(Thread.currentThread().getName() + "   " +  num);
                    num++;
                    flag = false;
                    lock.unlock();
                }
            }
        }
    }

    private class OutThread extends Thread {

        @Override
        public void run() {
            while (num < 100) {
                if (!flag) {
                    lock.lock();
                    System.out.println(Thread.currentThread().getName() + "   " +  num);
                    num++;
                    flag = true;
                    lock.unlock();
                }
            }
        }
    }
    public static void main(String[] args) {

        JiOutThread jiOutThread = new JiOutThread();


    }

}
