package lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @Package Name : ${PACKAG_NAME}
 * @Author : 1766318593@qq.com
 * @Creation Date : 2018年05月29日下午3:15
 * @Function : todo
 */
public class ReentrantLockTest extends Thread {

    public static ReentrantLock lockRe = new ReentrantLock();
    public static int i = 0;

    public ReentrantLockTest(String name){
        super.setName(name);
    }

    @Override
    public void run(){
        for (int j=0;j<10000;++j){
            lockRe.lock();
            lockRe.lock();  // 可重入
            /*
            由于ReentrantLock是重入锁，所以可以反复得到相同的一把锁，它有一个与锁相关的获取计数器，
            如果拥有锁的某个线程再次得到锁，那么获取计数器就加1，然后锁需要被释放两次才能获得真正释放(重入锁)。

             */

            try {
                System.out.println(this.getName()+" "+ i);
                i++;
            } finally {
                lockRe.unlock();
                System.out.println("tuichu");
                //lockRe.unlock();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException{

        ReentrantLockTest test1 =  new ReentrantLockTest("thread1");
        ReentrantLockTest test2 =  new ReentrantLockTest("thread2");

        test1.start();
        test2.start();

        test1.join();
        test2.join();
        System.out.println(i);
    }

}
