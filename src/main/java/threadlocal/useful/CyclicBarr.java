package threadlocal.useful;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CyclicBarrier;

/**
 * @Package Name : ${PACKAG_NAME}
 * @Author : dongfucai@meituan.com
 * @Creation Date : 2019年02月01日下午6:17
 * @Function : todo
 */
@Slf4j
public class CyclicBarr {

    public static void main(String[] args) throws Exception{

        cyclicBarrier();
    }

    private static void cyclicBarrier() throws Exception {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3) ;

        new Thread(new Runnable() {
            @Override
            public void run() {
                log.info("thread run");
                System.out.println("thread run");
                try {
                    cyclicBarrier.await() ;
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println("thread end do something");
                log.info("thread end do something");
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("thread run");
                log.info("thread run");
                try {
                    cyclicBarrier.await() ;
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println("thread end do something");
                log.info("thread end do something");
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("thread run");
                log.info("thread run");
                try {
                    Thread.sleep(5000);
                    cyclicBarrier.await() ;
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println("thread end do something");
                log.info("thread end do something");
            }
        }).start();

        System.out.println("main thread");
        log.info("main thread");
    }

    private List list = new ArrayList();

}
