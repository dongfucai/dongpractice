package lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Package Name : ${PACKAG_NAME}
 * @Author : 1766318593@qq.com
 * @Creation Date : 2018年10月30日下午11:38
 * @Function : todo
 */

/**
 * 3 可限时
 * 超时不能获得锁，就返回false，不会永久等待构成死锁
 *
 * 使用lock.tryLock(long timeout, TimeUnit unit)来实现可限时锁，参数为时间和单位。
 *
 * 两个线程来争夺一把锁，获得锁的线程sleep6秒，每个线程都只尝试5秒去获得锁。
 * 所以必定有一个线程无法获得锁。无法获得后就直接退出了。
 */
public class TryLockTest extends Thread{

    public static ReentrantLock lock = new ReentrantLock();

    public TryLockTest(String name){
        super(name);
    }

    @Override
    public void run() {
        try {
            if (lock.tryLock(5, TimeUnit.SECONDS)) {
                Thread.sleep(6000);
            } else {
                System.out.println(this.getName() + " get lock failed");
            }
        } catch (Exception e) {
        } finally {
            if (lock.isHeldByCurrentThread()) {
                System.out.println("lock.isHeldByCurrentThread: " + this.getName());
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        TryLockTest t1 = new TryLockTest("TryLockTest1");
        TryLockTest t2 = new TryLockTest("TryLockTest2");

        t1.start();
        t2.start();
    }

}
