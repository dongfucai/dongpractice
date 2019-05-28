package util;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;

/**
 * @Package Name : ${PACKAG_NAME}
 * @Author : 1766318593@qq.com
 * @Creation Date : 2018年09月07日下午2:39
 * @Function : todo
 */
public class ThreadUtils {


    /**
     * 自定义线程池(有界队列 + 自定义线程名),默认使用abort策略
     * @param coreThreadSize
     * @param maxThreadSize
     * @param queueSize
     * @param threadNameFormat
     * @return
     */
    public static ExecutorService createPoolWithFixQueue(int coreThreadSize, int maxThreadSize, int queueSize, String threadNameFormat){
        ThreadFactory threadFactory = new ThreadFactoryBuilder()
                .setNameFormat(threadNameFormat)
                .setDaemon(true)
                .build();

        final BlockingQueue<Runnable> queue = new ArrayBlockingQueue<>(queueSize);

        return new ThreadPoolExecutor(coreThreadSize, maxThreadSize,
                60L, TimeUnit.SECONDS,
                queue,threadFactory,new ThreadPoolExecutor.AbortPolicy());
    }
    public static ExecutorService createPoolWithFixQueue(int coreThreadSize,int maxThreadSize,int queueSize,String threadNameFormat,RejectedExecutionHandler rejectedExecutionHandler){
        ThreadFactory threadFactory = new ThreadFactoryBuilder()
                .setNameFormat(threadNameFormat)
                .setDaemon(true)
                .build();

        final BlockingQueue<Runnable> queue = new ArrayBlockingQueue<>(queueSize);

        return new ThreadPoolExecutor(coreThreadSize, maxThreadSize,
                60L, TimeUnit.SECONDS,
                queue,threadFactory,rejectedExecutionHandler);
    }

}
