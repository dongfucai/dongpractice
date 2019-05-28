package com.threadpool;

/**
 * @Package Name : ${PACKAG_NAME}
 * @Author : dongfucai@meituan.com
 * @Creation Date : 2019年02月13日下午9:39
 * @Function : todo
 */

import java.util.LinkedList;

public class NetJavaThreadPool {
    private final int initThreadCount;
    private final PoolWorker[] threadPool;
    private final LinkedList<Runnable> workerList;



    public NetJavaThreadPool(int initThreadCount) {
        this.initThreadCount = initThreadCount;
        workerList = new LinkedList<Runnable>();
        threadPool = new PoolWorker[initThreadCount];
        for(int i=0;i<threadPool.length;i++)
        {
            threadPool[i]=new PoolWorker();
            threadPool[i].setName(i+"号线程");
            threadPool[i].start();
            System.out.println("---"+i+"号线程已经创建，在等待任务中");

        }
        System.out.println("***线程池初始化完毕***");
    }

    public void execute(Runnable worker){
        synchronized (workerList) {
            workerList.addLast(worker);
            workerList.notify();
            System.out.println("---加入了一个任务！！！");
        }
    }


    private class PoolWorker extends Thread {
        @Override
        public void run(){
            Runnable r;
            while(true){
                synchronized (workerList) {
                    while(workerList.isEmpty()){
                        try {
                            workerList.wait();
                        } catch (InterruptedException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }

                    }
                    r=(Runnable)workerList.removeFirst();

                }
                r.run();
            }
        }

    }

    public static void main(String a[])
    {
        //10个任务给带有5个线程的线程池执行，每个任务就是数0到19，一个线程要把一个任务执行结束才去执行下一个任务
        NetJavaThreadPool wq=new NetJavaThreadPool(5);
        for(int i=0;i<10;i++){
            final int task=i;
            wq.execute(new Runnable() {

                @Override
                public void run() {
                    for(int i=0;i<20;i++)
                    {
                        try {
                            Thread.sleep(30);
                        } catch (InterruptedException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                        System.out.println(Thread.currentThread().getName()+"  is looping of  "+i+"  for task of "+task);
                    }

                }
            });
        }
    }

}
