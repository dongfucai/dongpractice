package product_consumer;

import java.util.concurrent.TimeUnit;

/**
 * @Package Name : ${PACKAG_NAME}
 * @Author : 1766318593@qq.com
 * @Creation Date : 2018年12月09日下午1:59
 * @Function : todo
 */
public class WaitPerson implements Runnable{

    private Restaurant restaurant;

    public WaitPerson(Restaurant r) {
        this.restaurant = r;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                synchronized (this) {
                    while (restaurant.meal == null)
                        wait();// ..for the chef to produce a meal
                }
                System.out.println("WaitPerson got" + restaurant.meal);
                synchronized (restaurant.chef) {
                    restaurant.meal = null;
                    restaurant.chef.notifyAll();// ready for another
                }
            }
            TimeUnit.MICROSECONDS.sleep(100);
        } catch (InterruptedException e) {
            System.out.println("WaitPerson interrupted");
        }
    }

}
