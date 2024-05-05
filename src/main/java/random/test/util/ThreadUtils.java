package random.test.util;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;

/**
 * @Author dongfucai/1766318593@qq.com
 * @Description //TODO
 * @Date 2020/11/12 上午10:16
 * @Version 1.0
 **/

public class ThreadUtils {



    /**
     * 自定义线程池(有界队列 + 自定义线程名),默认使用abort策略
     *
     * @param coreThreadSize
     * @param maxThreadSize
     * @param queueSize
     * @param threadNameFormat
     * @return
     */
    public static ExecutorService createPoolWithFixQueue(int coreThreadSize, int maxThreadSize, int queueSize, String threadNameFormat) {
        ThreadFactory threadFactory = new ThreadFactoryBuilder()
                .setNameFormat(threadNameFormat)
                .setDaemon(true)
                .build();

        final BlockingQueue<Runnable> queue = new ArrayBlockingQueue<>(queueSize);

        return new ThreadPoolExecutor(coreThreadSize, maxThreadSize,
                60L, TimeUnit.SECONDS,
                queue, threadFactory, new ThreadPoolExecutor.AbortPolicy());
    }

    public static ExecutorService createPoolWithFixQueue(int coreThreadSize, int maxThreadSize, int queueSize, String threadNameFormat, RejectedExecutionHandler rejectedExecutionHandler) {
        ThreadFactory threadFactory = new ThreadFactoryBuilder()
                .setNameFormat(threadNameFormat)
                .setDaemon(true)
                .build();

        final BlockingQueue<Runnable> queue = new ArrayBlockingQueue<>(queueSize);

        return new ThreadPoolExecutor(coreThreadSize, maxThreadSize,
                60L, TimeUnit.SECONDS,
                queue, threadFactory, rejectedExecutionHandler);
    }

    /**
     * 获取对象
     *
     * @param future
     * @param <T>
     * @return
     */
    public static <T> T getFutureResult(Future<T> future) {
        T result = null;
        try {
            result = future.get();
        } catch (Exception e) {
        }
        return result;
    }

}
