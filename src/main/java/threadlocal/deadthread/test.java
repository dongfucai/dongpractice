package threadlocal.deadthread;

import org.junit.Test;

public class test {

    @Test
    public void  forName() {

        boolean log4jIsAvailable = false;
        // Is Log4J Available?
        try {
            log4jIsAvailable = null != Class.forName("threadlocal.deadthread.DeadDemo");
        } catch (Throwable t) {
            log4jIsAvailable = false;
        }

        System.out.println(log4jIsAvailable);

    }


}
