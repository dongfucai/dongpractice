package lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @Package Name : ${PACKAG_NAME}
 * @Author : 1766318593@qq.com
 * @Creation Date : 2018年05月29日下午3:34
 * @Function : ReentrantLock 可中断
 */

/**
 * 可中断
 */
public class LockInterrupt extends Thread{

    public static ReentrantLock lock1 = new ReentrantLock();
    public static ReentrantLock lock2 = new ReentrantLock();

    int lock;

    public LockInterrupt(int lock,String name){
        super(name);
        this.lock=lock;
    }

    @Override
    public void run() {
        try {
            if (lock == 1) {
                lock1.lockInterruptibly();
                try {
                    Thread.sleep(500);
                } catch (Exception e) {
                    // TODO: handle exception
                }
                lock2.lockInterruptibly();
            } else {
                lock2.lockInterruptibly();
                try {
                    Thread.sleep(500);
                } catch (Exception e) {
                    // TODO: handle exception
                }
                lock1.lockInterruptibly();
            }
        } catch (Exception e) {
            // TODO: handle exception
        } finally {
            if (lock1.isHeldByCurrentThread()) {
                lock1.unlock();
            }
            if (lock2.isHeldByCurrentThread()) {
                lock2.unlock();
            }
            System.out.println(Thread.currentThread().getId() + ":线程退出");
        }
    }



    public static void main(String[] args) throws  InterruptedException{

        LockInterrupt t1 = new LockInterrupt(1, "LockInterrupt1");
        LockInterrupt t2 = new LockInterrupt(2, "LockInterrupt2");
        t1.start();
        t2.start();
        Thread.sleep(1000);


    }

}
