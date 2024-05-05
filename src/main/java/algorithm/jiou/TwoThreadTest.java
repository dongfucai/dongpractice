package algorithm.jiou;

/**
 * @Author dongfucai/1766318593@qq.com
 * @Description //TODO
 * @Date 2021/3/25 下午6:56
 * @Version 1.0
 **/

public class TwoThreadTest {


    static public class CountWarper {
        private volatile Integer count;

        CountWarper(Integer count) {
            this.count = count;
        }

        public Integer getCount() {
            return count;
        }

        public void setCount(Integer count) {
            this.count = count;
        }
    }

    static public class OneThread implements Runnable {

        private CountWarper countWarper;

        public OneThread(CountWarper countWarper) {
            this.countWarper = countWarper;
        }

        @Override
        public void run() {
            try {
                synchronized (countWarper) {
                    while (countWarper.getCount() < 100) {
                        if (countWarper.getCount() % 2 == 0) {
                            countWarper.wait();
                        } else {
                            System.out.println("ji da yin : " + countWarper.getCount());
                            countWarper.setCount(countWarper.getCount() + 1);
                            countWarper.notify();
                        }
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }


    static public class TwoThread implements Runnable {

        private CountWarper countWarper;

        public TwoThread(CountWarper countWarper) {
            this.countWarper = countWarper;
        }

        @Override
        public void run() {
            try {
                synchronized (countWarper) {
                    while (countWarper.getCount() < 100) {
                        if (countWarper.getCount() % 2 == 1) {
                            countWarper.wait();
                        } else {
                            System.out.println("ou da yin : " + countWarper.getCount());
                            countWarper.setCount(countWarper.getCount() + 1);
                            countWarper.notify();
                        }
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    static public class ThreeThread implements Runnable {

        private CountWarper countWarper;

        public ThreeThread(CountWarper countWarper) {
            this.countWarper = countWarper;
        }

        @Override
        public void run() {
            try {
                synchronized (countWarper) {
                    while (countWarper.getCount() < 100) {
                        if (countWarper.getCount() % 2 == 1) {
                            countWarper.wait();
                        } else {
                            System.out.println("ou da yin : " + countWarper.getCount());
                            countWarper.setCount(countWarper.getCount() + 1);
                            countWarper.notify();
                        }
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }




    public static void main(String[] args) {

        CountWarper countWarper = new CountWarper(1);
        Integer count = 0;
        OneThread jiThread = new OneThread(countWarper);

        TwoThread ouThread = new TwoThread(countWarper);

        new Thread(jiThread).start();
        new Thread(ouThread).start();

        if (42 == 42.0) {
            System.out.println("equal ");
        }


    }
}
