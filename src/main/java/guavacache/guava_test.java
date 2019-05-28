package guavacache;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.util.concurrent.ListenableFuture;
import org.junit.Test;
import util.JacksonUtil;


import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @Package Name : ${PACKAG_NAME}
 * @Author : dongfucai@meituan.com
 * @Creation Date : 2019年01月05日下午2:55
 * @Function : todo
 */
public class guava_test {



    public static void main(String[] args) throws Exception{

        LoadingCache<Long, String> strCache = CacheBuilder.newBuilder().maximumSize(1000)
                .expireAfterWrite(2, TimeUnit.SECONDS)
                .build(new CacheLoader<Long, String>() {
                    //有这个键就从缓存中去 没有就根据load方法从新获取
                    //如果load没有显示抛出异常 可以用getUnchecked查找缓存 如果显示抛出 就不能使用getUnchecked
                    @Override
                    public String load(Long o) throws Exception {
                        return "缓存3343:" + o;
                    }

                    //批量加载
                    @Override
                    public Map<Long, String> loadAll(Iterable<? extends Long> keys) throws Exception {
                        Map<Long,String> tempMap = Maps.newConcurrentMap();
                        keys.forEach(key->{
                            tempMap.put(key,"缓存:"+key);
                        });
                        return tempMap;
                    }
                    //重新加载
//                    @Override
//                    public ListenableFuture<String> reload(Long key, String oldValue) throws Exception {
//                        return super.reload(key, oldValue);
//                    }
                });


        List list = Lists.newArrayList();

        list.add(345L);
        list.add(123L);
        list.add(788L);


        System.out.println(strCache.getAll(list));
        System.out.println(strCache.get(345L));

        Thread.sleep(3000);
        System.out.println(strCache.get(345L));

        System.out.println(strCache.get(1L));
        System.out.println(strCache.get(1L));
        System.out.println(strCache.get(2L));

    }

    private List<List<String>> splitList(List<String> list , int groupSize){
        return  Lists.partition(list, groupSize); // 使用guava
    }

    @Test
    public void splitTest() {

        List<String> list = Lists.newLinkedList();
        for (int i = 0; i < 100; ++i) {
            list.add(i + "");
        }

        List<List<String>> lists = splitList(list, 900);
        for (List<String> stringList : lists) {
            try {
                System.out.println(JacksonUtil.toJsonStr(stringList));
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        }
    }
}
