package lock;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Package Name : ${PACKAG_NAME}
 * @Author : 1766318593@qq.com
 * @Creation Date : 2018年05月29日下午3:15
 * @Function : todo
 */

// 1 可重入

/**
 * 为什么要可重入
 * 作者：cbhe
 * 链接：https://www.zhihu.com/question/23284564/answer/167610370
 * 来源：知乎
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 *
 * 重入进一步提升了加锁行为的封装性，因而简化了面向对象并发代码的开发。在以下程序中，子类改写了父类的 synchronized 方法，然后调用父类中的方法，此时如果内置锁不是可重入的，那么这段代码将产生死锁。由于 Widget 和 LoggingWidget 中 doSomething 方法都是 synchronized 方法，因此每个每个 doSomething 方法在执行前都会获取 Widget 上的锁。然而如果内置锁不是可重入的，那么调用 super.doSomething( )时无法获得 Widget 上的锁，因为这个锁已经被持有，从而线程将永远停顿下去，等待一个永远也无法获得的锁。重入则避免了这种死锁情况的发生。public class Widget{
 *     public synchronized void doSomething(){
 *         ........
 *     }
 * }
 *
 * public class LoggingWidget extends Widget{
 *     public synchronized void doSomething(){
 *         super.doSomething();
 *     }
 * }
 */
public class ReentrantLockTest extends Thread {

    public static ReentrantLock lockRe = new ReentrantLock(true);
    public static int i = 0;




    public ReentrantLockTest(String name){
        super.setName(name);
    }

    @Override
    public void run() {

        try {
            sleep((long)(Math.random()*100));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        lockRe.lock();



        for (int j=0;j<10;++j){

           // lockRe.lock();  // 可重入
            /*
            由于ReentrantLock是重入锁，所以可以反复得到相同的一把锁，它有一个与锁相关的获取计数器，
            如果拥有锁的某个线程再次得到锁，那么获取计数器就加1，然后锁需要被释放两次才能获得真正释放(重入锁)。

             */

            try {
                System.out.println(this.getName()+" "+ i);
                i++;
            } finally {

                System.out.println("tuichu");
                //lockRe.unlock();
            }
        }
        lockRe.unlock();
        try {
            lockRe.tryLock(100,TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException{

//        ReentrantLockTest test1 =  new ReentrantLockTest("thread1");
//        ReentrantLockTest test2 =  new ReentrantLockTest("thread2");
//
//        test1.start();
//        test2.start();
//
//        test1.join();
//        test2.join();


        for (int i = 0; i < 100; ++i){
            new ReentrantLockTest("thread" + i).start();
        }
        System.out.println(i);
    }

}
