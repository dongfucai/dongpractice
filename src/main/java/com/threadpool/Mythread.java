package com.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Mythread {


    /**
     * 线程池的线程执行规则跟任务队列有很大的关系。
     *
     * 下面都假设任务队列没有大小限制：
     *
     * 如果线程数量<=核心线程数量，那么直接启动一个核心线程来执行任务，不会放入队列中。
     * 如果线程数量>核心线程数，但<=最大线程数，并且任务队列是LinkedBlockingDeque的时候，超过核心线程数量的任务会放在任务队列中排队。
     * 如果线程数量>核心线程数，但<=最大线程数，并且任务队列是SynchronousQueue的时候，线程池会创建新线程执行任务，这些任务也不会被放在任务队列中。这些线程属于非核心线程，在任务完成后，闲置时间达到了超时时间就会被清除。
     * 如果线程数量>核心线程数，并且>最大线程数，当任务队列是LinkedBlockingDeque，会将超过核心线程的任务放在任务队列中排队。也就是当任务队列是LinkedBlockingDeque并且没有大小限制时，线程池的最大线程数设置是无效的，他的线程数最多不会超过核心线程数。
     * 如果线程数量>核心线程数，并且>最大线程数，当任务队列是SynchronousQueue的时候，会因为线程池拒绝添加任务而抛出异常。
     * 任务队列大小有限时
     *
     * 当LinkedBlockingDeque塞满时，新增的任务会直接创建新线程来执行，当创建的线程数量超过最大线程数量时会抛异常。
     * SynchronousQueue没有数量限制。因为他根本不保持这些任务，而是直接交给线程池去执行。当任务数量超过最大线程数时会直接抛异常。
     * @param args
     */



    public static void main(String[] args){


        ExecutorService executorService= new ThreadPoolExecutor(3,4,5,TimeUnit.SECONDS,new LinkedBlockingDeque<>(10));

        ThreadPoolExecutor executor= new ThreadPoolExecutor(3,4,5,TimeUnit.SECONDS,new LinkedBlockingDeque<>(10));

      //  ThreadPoolExecutor executor = new ThreadPoolExecutor(6, 10, 5, TimeUnit.SECONDS, new SynchronousQueue<Runnable>());

        Runnable myRunnable = new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                    System.out.println(Thread.currentThread().getName()+ "  run");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } ;

//        Runnable myRunnable = new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    Thread.sleep(2000);
//                    System.out.println(Thread.currentThread().getName() + " run");
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//
//            }
//        };


     //   executor.allowCoreThreadTimeOut(false); // 默认是false 不会回收



        System.out.println("---任务开始之前---");
        System.out.println("核心线程数量 " + executor.getCorePoolSize());
        System.out.println("线程池数量  " + executor.getPoolSize());
        System.out.println("队列任务数量 "  + executor.getQueue().size());

        executor.execute(myRunnable);


        System.out.println("---开启任务一个---");  // 初始化后，进行
        System.out.println("核心线程数量 " + executor.getCorePoolSize());
        System.out.println("线程池数量  " + executor.getPoolSize());
        System.out.println("队列任务数量 "  + executor.getQueue().size());



        executor.execute(myRunnable);
        executor.execute(myRunnable);


        System.out.println("---先开三个---");
        System.out.println("核心线程数" + executor.getCorePoolSize());
        System.out.println("线程池数" + executor.getPoolSize());
        System.out.println("队列任务数" + executor.getQueue().size());
        executor.execute(myRunnable);
        executor.execute(myRunnable);
        executor.execute(myRunnable);
        System.out.println("---再开三个---");
        System.out.println("核心线程数" + executor.getCorePoolSize());
        System.out.println("线程池数" + executor.getPoolSize());
        System.out.println("队列任务数" + executor.getQueue().size());

        try {
            Thread.sleep(8000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("----8秒之后----");
        System.out.println("核心线程数" + executor.getCorePoolSize());
        System.out.println("线程池数" + executor.getPoolSize());
        System.out.println("队列任务数" + executor.getQueue().size());

    }

}
