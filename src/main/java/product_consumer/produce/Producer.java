package product_consumer.produce;

import java.util.concurrent.BlockingQueue;

/**
 * @Package Name : ${PACKAG_NAME}
 * @Author : 1766318593@qq.com
 * @Creation Date : 2018年12月09日下午2:11
 * @Function : todo
 *
 *
 * add        增加一个元索                     如果队列已满，则抛出一个IIIegaISlabEepeplian异常
 * remove   移除并返回队列头部的元素    如果队列为空，则抛出一个NoSuchElementException异常
 * element  返回队列头部的元素             如果队列为空，则抛出一个NoSuchElementException异常
 * offer       添加一个元素并返回true       如果队列已满，则返回false
 * poll         移除并返问队列头部的元素    如果队列为空，则返回null
 * peek       返回队列头部的元素             如果队列为空，则返回null
 * put         添加一个元素                      如果队列满，则阻塞
 * take        移除并返回队列头部的元素     如果队列为空，则阻塞
 *
 */
public class Producer implements Runnable{

    BlockingQueue<String> queue;

    public Producer(BlockingQueue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {

        int i = 0;
        while (true) {
            try {
                System.out.println("生产者生产食物， 食物编号为：" + i);
                queue.put(" 食物 " + i++);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("生产者被中断");
            }
        }
    }

}
