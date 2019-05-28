package product_consumer;

import product_consumer.consumer.Concumer;
import product_consumer.produce.Producer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @Package Name : ${PACKAG_NAME}
 * @Author : 1766318593@qq.com
 * @Creation Date : 2018年12月09日下午2:12
 * @Function : todo
 */
public class testPC {

    public static void main(String[] args) {
        BlockingQueue<String> queue = new ArrayBlockingQueue<String>(20);
        Thread pro = new Thread(new Producer(queue), "生产者");
        pro.start();
        for (int i = 0; i < 10; i++) {
            Thread t = new Thread(new Concumer(queue), "消费者 " + i);
            t.start();
        }

    }

}
