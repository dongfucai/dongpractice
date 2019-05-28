package testnull.TestNull;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Package Name : ${PACKAG_NAME}
 * @Creation Date : 2019年01月01日下午10:02
 * @Function : todo
 */

/**
 *  TreeMap、TreeSet两个类在加入第二个元素时，会调用Comparator比较器比较先后加入的元素是否重复（TreeMap比较的是Key值）
 * 。所以当加入第一个元素时，即使第一个元素是null，也不会报错，因为此时不会调用比较器，再次加入元素则报错。
 *
 *  已测试的其他集合类HashSet / HashMap / ArrayList / LinkedList均可接受null值。
 *
 *HashMap可以允许插入null key和null value
 *
 * HashTable和ConcurrentHashMap都不可以插入null key和null value
 * ---------------------
 *
 */
public class TestNull {

    public static void main(String[] args) {


        //HashMap  允许null-null键值对
        Map<String,String> hashMap = new HashMap<String,String>();
        hashMap.put("11", "ddd");
        hashMap.put("1233", null);
        hashMap.put("10", null);
        hashMap.put(null, "wang");
        hashMap.put(null, null);
        System.out.println("HashMap以上代码运行成功");

        System.out.println(hashMap);

        Map concurrentHashMap = new ConcurrentHashMap<>();
       // concurrentHashMap.put(null, 67);


        //TreeMap  允许value值为null，不允许key值为null
        TreeMap<String,String> treeMap = new TreeMap<String,String>();

        //Map放入第一个元素时不会调用比较器，所以不会调用比较器，不会出现NullPointerException
        //以下一行代码执行时不会报错，但当treeMapp中放入元素大于1时，就会调用比较器，出现NullPointerException
        // treeMap.put(null, null);
        treeMap.put("ddd", null);
        treeMap.put("sss", null);
        System.out.println("TreeMap以上代码运行成功");


        //HashSet
        Set<String> hashSet = new HashSet<String>();
        hashSet.add(null);
        hashSet.add("ddd");
        System.out.println("HashSet以上代码运行成功");

        //TreeSet
        Set<String> treeSet = new TreeSet<String>();
        //以下两行代码执行时，会报错。理由同TreeMap
        //treeSet.add(null);
        treeSet.add("sss");
        System.out.println("TreeSet以上代码运行成功");

        //ArrayList
        List<String> arrayList = new ArrayList<String>();
        arrayList.add(null);
        arrayList.add("dd");
        System.out.println("ArrayList以上代码运行成功");

        //LinkedList
        List<String> linkedList = new LinkedList<String>();
        linkedList.add(null);
        linkedList.add("ddd");
        System.out.println("LinkedList以上代码运行成功");

        //Vector
        Vector<Integer> integerVector = new Vector<>();
        integerVector.add(null);
        integerVector.add(34);
        System.out.println("Vector success");

    }

}
