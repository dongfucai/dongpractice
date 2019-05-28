package product_consumer.consumer;

import java.util.concurrent.BlockingQueue;

/**
 * @Package Name : ${PACKAG_NAME}
 * @Author : 1766318593@qq.com
 * @Creation Date : 2018年12月09日下午2:12
 * @Function : todo
 *
 * 用ArrayBlockingQueue解决生产者消费者问题；默认使用的是非公平锁
 *
 * take():取走BlockingQueue里排在首位的对象,若BlockingQueue为空,阻断进入等待状态直到Blocking有新的对象被加入为止，若请求不到此线程被加入阻塞队列；
 *
 * 如果使用公平锁，当有内容可以消费时，会从队首取出消费者线程进行消费(即等待时间最长的线程)
 *
 * add(anObject):把anObject加到BlockingQueue里,即如果BlockingQueue可以容纳,则返回true,否则招聘异常
 */
public class Concumer implements Runnable{

    BlockingQueue<String> queue;

    public Concumer(BlockingQueue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                System.out.println(Thread.currentThread().getName() + "消费："
                        + queue.take());
            } catch (InterruptedException e) {
                System.out.println("消费者被中断");
            }
        }
    }

}
