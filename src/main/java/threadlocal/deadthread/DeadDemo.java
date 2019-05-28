package threadlocal.deadthread;

import java.io.IOException;

/**
 * @Package Name : ${PACKAG_NAME}
 * @Author : dongfucai@meituan.com
 * @Creation Date : 2019年03月10日下午9:53
 * @Function : todo
 */
public class DeadDemo {

    public static void main(String[] args) throws IOException, InterruptedException {
        for (int i = 0; i < 100; i++) {
            new Thread(new SyncLockRunnable(1, 2)).start();
            new Thread(new SyncLockRunnable(2, 1)).start();
        }
    }

    static class SyncLockRunnable implements Runnable {
        int a, b;

        public SyncLockRunnable(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public void run() {
            synchronized (Integer.valueOf(a)) {
                synchronized (Integer.valueOf(b)) {
                    System.out.println(a + b);
                }
            }
        }
    }

}
