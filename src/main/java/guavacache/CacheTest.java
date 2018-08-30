package guavacache;

import com.google.common.cache.*;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * @Package Name : ${PACKAG_NAME}
 * @Author : 1766318593@qq.com
 * @Creation Date : 2018年05月29日上午11:38
 * @Function : todo
 */
public class CacheTest {

    public static class Student{
        private int id;
        public String name;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString(){
            return id+"|"+name;
        }

    }
    public static void main(String[] args) throws ExecutionException,InterruptedException {

        // 缓存接口这里是LoadingCache，LoadingCache在缓存项不存在时可以自动加载缓存
        LoadingCache<Integer, Student> studentLoadingCache
                // CacheBuilder的构造函数是私有的，只能通过其静态方法newBuilder()来获得CacheBuilder的实例
        = CacheBuilder.newBuilder()

                // 设置并发级别为8，并发级别是指可以同时写缓存的线程数
                .concurrencyLevel(8)
                // 设置写缓存后8秒钟过期
                .expireAfterWrite(18, TimeUnit.SECONDS)
                // 设置缓存容器的初始容量为10
                .initialCapacity(2)
                // 设置缓存最大容量为100，超过100之后就会按照LRU最近虽少使用算法来移除缓存项
                .maximumSize(2)
                // 设置要统计缓存的命中率
                .recordStats()
        // 设置缓存的移除通知
                .removalListener(new RemovalListener<Object, Object>() {
                    public void onRemoval(RemovalNotification<Object, Object> notification) {
                        System.out.println(
                                notification.getKey() + " was removed, cause is " + notification.getCause());
                    }
                })
                //       // build方法中可以指定CacheLoader，在缓存不存在时通过CacheLoader的实现自动加载缓存
                .build(new CacheLoader<Integer, Student>() {
                    @Override
                    public Student load(Integer key) throws Exception {
                        System.out.println("load student " + key);
                        Student student = new Student();
                        student.setId(key);
                        student.setName("name " + key);
                        return student;
                    }
                });
//
//        for (int i = 0; i < 5; i++) {
//          // 从缓存中得到数据，由于我们没有设置过缓存，所以需要通过CacheLoader加载缓存数据
//          Student student = studentLoadingCache.get(i);
//          System.out.println(student);
//          // 休眠1秒
//          TimeUnit.SECONDS.sleep(1);
//         }

        Student student = studentLoadingCache.get(1);
        System.out.println(student);
        student = studentLoadingCache.get(1);
        System.out.println(student);
        student = studentLoadingCache.get(1);
        System.out.println(student);

        student = studentLoadingCache.get(2);
        System.out.println(student);

        student = studentLoadingCache.get(3);
        System.out.println(student);

        System.out.println("cache stats:");
        // 最后打印缓存的命中率等 情况
        System.out.println(studentLoadingCache.stats().toString());


    }

}
