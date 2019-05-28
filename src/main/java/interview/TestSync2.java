package interview;

/**
 * @Package Name : ${PACKAG_NAME}
 * @Author : 1766318593@qq.com
 * @Creation Date : 2018年11月06日上午12:08
 * @Function : todo
 */
public class TestSync2 implements Runnable {
    int b = 100;

    synchronized void m1() throws InterruptedException {
        b = 1000;
        //Thread.sleep(500); //6
        System.out.println("b=" + b);
    }

    synchronized void m2() throws InterruptedException {
        //Thread.sleep(250); //5
        b = 2000;
    }

    public static void main(String[] args) throws InterruptedException {
        TestSync2 tt = new TestSync2();
        Thread t = new Thread(tt);  //1
        t.start(); //2

        tt.m2(); //3
        System.out.println("main thread b=" + tt.b); //4
    }

    @Override
    public void run() {
        try {
            m1();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
/**

 下面开始简单分析：
 该题目涉及到2个线程（主线程main、子线程）、关键词涉及到synchronized、Thread.sleep。
 synchronized关键词还是比较复杂的（可能有时候没有理解到位所以上面题目会有点误区），他的作用就是实现线程的同步（实现线程同步有很多方法，它只是一种，后续文章会说其他的，需要好好研究大神Doug Lea的一些实现），它的工作就是对需要同步的代码加锁，使得每一次只有一个线程可以进入同步块（其实是一种悲观策略）从而保证线程只记得安全性。
 一般关键词synchronized的用法

 指定加锁对象:对给定对象加锁，进入同步代码前需要活的给定对象的锁。
 直接作用于实例方法:相当于对当前实例加锁，进入同步代码前要获得当前实例的锁。
 直接作用于静态方法:相当于对当前类加锁，进入同步代码前要获得当前类的锁。

 上面的代码，synchronized用法其实就 属于第二种情况。直接作用于实例方法:相当于对当前实例加锁，进入同步代码前要获得当前实例的锁。
 可能存在的误区

 由于对synchronized理解的不到位，由于很多时候，我们多线程都是操作一个synchronized的方法，当2个线程调用2个不同synchronized的方法的时候，认为是没有关系的，这种想法是存在误区的。直接作用于实例方法:相当于对当前实例加锁，进入同步代码前要获得当前实例的锁。
 如果一个调用synchronized方法。另外一个调用普通方法是没有关系的，2个是不存在等待关系的。

 这些对于后面的分析很有作用。
 Thread.sleep
 使当前线程（即调用该方法的线程）暂停执行一段时间，让其他线程有机会继续执行，**但它并不释放对象锁。也就是说如果有synchronized同步快，其他线程仍然不能访问共享数据。**注意该方法要捕捉异常，对于后面的分析很有作用。一些细节可以参考我的系统学习java高并发系列二。

 作者：匠心零度
 链接：https://juejin.im/post/59f9804851882554b836dd8b
 来源：掘金
 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。


 */