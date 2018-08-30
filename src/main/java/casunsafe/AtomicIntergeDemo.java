package casunsafe;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Package Name : ${PACKAG_NAME}
 * @Author : dongfucai@meituan.com
 * @Creation Date : 2018年05月14日下午5:59
 * @Function : todo
 */
public class AtomicIntergeDemo {

    static AtomicInteger i = new AtomicInteger();

    public static  class AddThread implements Runnable{
        public void run(){
            for( int k=0;k<10000;k++){
                i.incrementAndGet();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException{
        Thread [] ts = new Thread[10];

        for(int i=0;i<10;++i){
            ts[i] = new Thread(new AddThread());
        }
        for (int i=0;i<10;++i){
            ts[i].start();
        }
        for (int i=0;i<10;++i){
            ts[i].join();
        }
        System.out.println(i);
    }

}
