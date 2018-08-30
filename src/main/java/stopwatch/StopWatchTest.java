package stopwatch;


import org.junit.rules.Stopwatch;

import java.util.concurrent.TimeUnit;
import org.springframework.util.StopWatch;
/**
 * @Package Name : ${PACKAG_NAME}
 * @Author : dongfucai@meituan.com
 * @Creation Date : 2018年06月08日下午4:05
 * @Function : todo
 */
public class StopWatchTest {

    public static void main(String[] args) throws InterruptedException {


        StopWatch sw;
        sw = new StopWatch();
        sw.start();
        Thread.sleep(1000);
        sw.stop();


        sw.start();
        Thread.sleep(100);
        sw.stop();
        sw.start();
        Thread.sleep(10);
        sw.stop();
        System.out.println(sw.prettyPrint());

    }

}
