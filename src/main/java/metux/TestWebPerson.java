package metux;

import java.util.ArrayList;
import java.util.List;

/**
 * @Package Name : ${PACKAG_NAME}
 * @Author : dongfucai@meituan.com
 * @Creation Date : 2018年06月23日下午5:31
 * @Function : todo
 */
public class TestWebPerson {


    public static List<Integer> numberList = new ArrayList<>();

    public static class AddToList implements Runnable{
        int startnum = 0;
        public AddToList (int startnum){
            this.startnum =startnum;
        }

        @Override
        public void run(){
            int count = 0;
            while (count < 1000000){
                numberList.add(startnum);
                // arrayList 往外扩容的时候，处于一种不可用的状态，
                // 而线程正在跑 还要往里面插进一个数据
                startnum+=2;
                count++;
            }
        }
    }

    public static void main(String[] args) throws InterruptedException{

        Thread t1 =  new Thread(new AddToList(0));
        Thread t2 =  new Thread(new AddToList(1));

        t1.start();
        t2.start();

        while (t1.isAlive()||t2.isAlive()){
            Thread.sleep(1);
        }

        System.out.println(numberList.size());
    }

}
