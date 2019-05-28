package product_consumer;

/**
 * @Package Name : ${PACKAG_NAME}
 * @Author : 1766318593@qq.com
 * @Creation Date : 2018年12月09日下午2:00
 * @Function : todo
 */
public class Chef implements Runnable{

    private Restaurant restaurant;
    private int count = 0;

    public Chef(Restaurant r) {
        this.restaurant = r;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                synchronized (this) {
                    while (restaurant.meal != null)
                        wait();// ...for the meal to be taken
                }
                if (++count == 10) {
                    System.out.println("Out of food,closing");
                    restaurant.exec.shutdownNow();
                }
                System.out.println("Order up!");
                synchronized (restaurant.waitPerson) {
                    restaurant.meal = new Meal(count);
                    restaurant.waitPerson.notifyAll();
                }

            }
        } catch (InterruptedException e) {
        }
    }

}
