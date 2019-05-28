package interview;

import com.google.common.collect.Lists;
import org.apache.commons.lang.math.NumberUtils;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * @Package Name : ${PACKAG_NAME}
 * @Author : dongfucai@meituan.com
 * @Creation Date : 2019年02月24日上午9:43
 * @Function : todo
 */
public class javaThreadPool {

    private  Integer initNumber;

    private List<Runnable>  runnableList; // 任务队列

    // 已经建立好线程数量
    private PoolThread[] poolThreads;

    javaThreadPool(Integer initNumber) {
        this.initNumber = initNumber;
        runnableList = new LinkedList<Runnable>();
        for (int i = 0; i < initNumber; ++i) {
            poolThreads[i] = new PoolThread();
            poolThreads[i].start();
        }


    }

    public void execute(Runnable task) {

        synchronized (runnableList){
            runnableList.add(task);
            runnableList.notify();
        }
    }

    private class PoolThread extends Thread {

        @Override
        public void run() {
            Runnable runnable = null;
            while (true) {
                synchronized (runnableList) {
                    while (runnableList.isEmpty()) {
                        try {
                            runnableList.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    runnable = runnableList.remove(0);
                }
                runnable.run();
            }
        }



    }
    public static void main(String[] args) {

        /**
         * 想是每次从未选中的数字中随机挑选一个加入排列，时间复杂度为O(n)，wiki上的伪代码如下
         */
        List list = Lists.newArrayList();
       // set<Integer> set1 = [1,2];

//        int len = list.size();
//        for (int i = len-1; i >= 0 ; --i) {
//            int a = Maths.random()%(i + 1);
//            swap(list.get(i), list.get(a));
//        }
        List list1 = Lists.newArrayListWithCapacity(2);
        System.out.println(list1.size());

        String str = NumberUtils.isDigits(null) ? "a" : "b";
        System.out.println(str);

        Object temp = null;
        Object own = null;
        Long userId = ((temp = own) == null) ? null : NumberUtils.isDigits(temp.toString()) ? Long.parseLong(temp.toString()) : null;
        System.out.println(userId);

    }

}
