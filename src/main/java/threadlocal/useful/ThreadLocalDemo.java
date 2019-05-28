package threadlocal.useful;


import threadlocal.util.MyCount;

import java.util.concurrent.CountDownLatch;

/**
 * @Package Name : ${PACKAG_NAME}
 * @Author : 1766318593@qq.com
 * @Creation Date : 2018年11月17日下午5:17
 * @Function : todo
 *
 */

/**
 * 合理的理解
 * ThreadLoal 变量，它的基本原理是，同一个 ThreadLocal 所包含的对象（对ThreadLocal< String >而言即为 String 类型变量），
 * 在不同的 Thread 中有不同的副本（实际是不同的实例，后文会详细阐述）。这里有几点需要注意
 *
 * 因为每个 Thread 内有自己的实例副本，且该副本只能由当前 Thread 使用。这是也是 ThreadLocal 命名的由来
 * 既然每个 Thread 有自己的实例副本，且其它 Thread 不可访问，那就不存在多线程间共享的问题
 * 既无共享，何来同步问题，又何来解决同步问题一说？
 */


/**
 * 总的来说，ThreadLocal 适用于每个线程需要自己独立的实例且该实例需要在多个方法中被使用，
 * 也即变量在线程间隔离而在方法或类间共享的场景。后文会通过实例详细阐述该观点。另外，该场景下，并非必须使用 ThreadLocal ，
 * 其它方式完全可以实现同样的效果，只是 ThreadLocal 使得实现更简洁。
 */
public class ThreadLocalDemo {

    public static void main(String[] args) throws InterruptedException {
        int threads = 3;
        CountDownLatch countDownLatch = new CountDownLatch(threads);
        InnerClass innerClass = new InnerClass();

        innerClass.set("head");
        for(int i = 1; i <= threads; i++) {
            new Thread(() -> {
                for(int j = 0; j < 4; j++) {
                    innerClass.add(String.valueOf(j));
                    innerClass.print();
                }
                innerClass.set("hello world");
                countDownLatch.countDown();
            }, "thread - " + i).start();
        }
        countDownLatch.await();

        System.out.println(11111111);
        System.out.println(MyCount.Counter.counter.get().toString());
    }



    private static class InnerClass {
        public void add(String newStr) {
            StringBuilder str = MyCount.Counter.counter.get();
            MyCount.Counter.counter.set(str.append(newStr));
        }
        public void print() {
            System.out.printf("Thread name:%s , ThreadLocal hashcode:%s, Instance hashcode:%s, Value:%s\n",
                    Thread.currentThread().getName(),
                    MyCount.Counter.counter.hashCode(),
                    MyCount.Counter.counter.get().hashCode(),
                    MyCount.Counter.counter.get().toString());
        }
        public void set(String words) {
            MyCount.Counter.counter.set(new StringBuilder(words));
            System.out.printf("Set, Thread name:%s , ThreadLocal hashcode:%s,  Instance hashcode:%s, Value:%s\n",
                    Thread.currentThread().getName(),
                    MyCount.Counter.counter.hashCode(),
                    MyCount.Counter.counter.get().hashCode(),
                    MyCount.Counter.counter.get().toString());
        }
    }

}
