package product_consumer;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Package Name : ${PACKAG_NAME}
 * @Author : 1766318593@qq.com
 * @Creation Date : 2018年12月09日下午2:00
 * @Function : todo
 */
public class Restaurant {

    Meal meal;
    ExecutorService exec = Executors.newCachedThreadPool();
    WaitPerson waitPerson = new WaitPerson(this);
    Chef chef = new Chef(this);

    public Restaurant() {
        exec.execute(chef);
        exec.execute(waitPerson);
    }
    public static void main(String[] args) {
        new Restaurant();
    }
}
