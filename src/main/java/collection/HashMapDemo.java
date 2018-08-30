package collection;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

/**
 * @Package Name : ${PACKAG_NAME}
 * @Author : dongfucai@meituan.com
 * @Creation Date : 2018年05月10日下午2:36
 * @Function : todo
 */
public class HashMapDemo {

    public static void main(String[] args) {
        Map<String,String> map=new HashMap<String,String>();
        map.put("01","zhangsan");
        map.put("02","list");
        map.put("03","wangyu");

        Collection<String> collection=map.values();  // 返回 values 的集合

        System.out.println(collection);

        Set<String> keySet=map.keySet();  // 先获取map集合的所有键值

        Iterator<String> it=keySet.iterator();  // 有了set的集合，获取迭代器

        while(it.hasNext()){
            String key=it.next();
            String value=map.get(key);
            System.out.println("key: "+ key + "--> value:"+value);
        }

        // 222222222222222222222
        // 通过 entrySet() 方法将 map集合的映射关系取出
        Set<Map.Entry<String,String> > entrySet=map.entrySet();
        //  将关系集合entrySet 进行迭代  , 放到迭代器中
        Iterator<Map.Entry<String,String> > it2=entrySet.iterator();

        while(it2.hasNext()){
            Map.Entry<String,String> me=it2.next();
            String key2=me.getKey();
            String value2=me.getValue();
            System.out.println("key : "+key2 + "---> value:"+ value2);
        }


        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();




        List<String> lines = Arrays.asList("spring", "node", "mkyong");
        // output "spring", "node"
        for (String temp : lines) {
            System.out.println(temp);
        }

    /* The equivalent example in Java 8, using stream.filter() to
  filter a list, and collect() to convert a stream.
   */
        List<String> result1 = lines.stream()  // convert list to stream
                .filter(line -> "mkyong".equals(line)).collect(Collectors.toList()); ;// filter the line which equals to "mkyong"


        System.out.println(result1);

    }

}
