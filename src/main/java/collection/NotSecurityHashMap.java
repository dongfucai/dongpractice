package collection;

import java.util.HashMap;
import java.util.UUID;

/**
 * @Package Name : ${PACKAG_NAME}
 * @Author : dongfucai@meituan.com
 * @Creation Date : 2018年07月27日上午11:12
 * @Function : todo
 */
public class NotSecurityHashMap {


    static final HashMap map = new HashMap();


    public static void main(String[] args) throws InterruptedException {

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0;i<10000;++i){
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            map.put(UUID.randomUUID().toString(),"");
                        }
                    },"tft"+i).start();
                }
            }
        });

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0;i<10000;++i){
                    map.put(UUID.randomUUID().toString(),"");
                }
            }
        });


        thread.start();
        thread1.start();

        thread.join();
        thread1.join();


    }

}
