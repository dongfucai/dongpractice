package interview.produce_consumer;


import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Package Name : ${PACKAG_NAME}
 * @Author : dongfucai@meituan.com
 * @Creation Date : 2019年02月24日上午8:50
 * @Function : todo
 */
public class ProduceAndConsumer<T> {


    private T[] data;

    //数组中的数量
    private Integer count;

    // put 的索引
    private Integer putIndex;

    // get 的索引
    private Integer takeIndex;


    public ProduceAndConsumer(Integer initCount) {
        this.data = (T[])new Object[initCount];
    }

    private ReentrantLock lock = new ReentrantLock();

    private Condition full = lock.newCondition();
    private Condition empty = lock.newCondition();


    public void put(T input) {
        lock.lock();

        try {
            if (data.length == count) {
                full.await();
            }
            data[count++] = input;

            if (count == 1) {
                empty.signalAll();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public T take() {
        lock.lock();
        try {
            if (count == 0) {
                empty.await();
            }

            T res = data[count-1];
            count -- ;
            if (count == data.length -1) {
                full.signalAll();
            }
            return res;
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        return null;
    }

    public static void main(String[] args) {


    }

}
