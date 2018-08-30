package stream;

import com.google.common.collect.Lists;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.sql.SQLOutput;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Package Name : ${PACKAG_NAME}
 * @Author : dongfucai@meituan.com
 * @Creation Date : 2018年05月12日下午6:18
 * @Function : todo
 */

// Stream 表示对一个序列的元素 进行 顺序和并行操作

    // 可以把Stream 当作成为一个高级版本的Iterator
public class list1 {



    public static void main(String[] args) {
           List<Integer> nums= Lists.newArrayList(1,null,3,4,null,6);

        System.out.println( nums.stream().filter(num -> num != null).count());
                       //   创建stream          转换stream            聚合

        // 1 创建stream 的方法
        /*
        最常用的创建Stream有两种途径：

          1）通过Stream接口的静态工厂方法（Note：Java8里接口可以带静态方法）。

          2）通过Collection接口的默认方法 stream()，把一个Collection对象转换成Stream
         */

        Stream<Integer> integerStream = Stream.of(1,5,9,5).filter(p -> p>2);
        Stream<String>  stringStream = Stream.of("jsdkfsf");

        // 对一系列元素进行并行操作 让程序员高效率，干净，简洁的代码


        List<Integer> integerList = Lists.newArrayList(1,1,null,2,3,4,null,5,6765,6,67,567);
        System.out.println("sum is:" + nums.stream().filter(num -> num !=null).distinct().collect(Collectors.toList()));

        integerList.stream().filter(num -> num != null).distinct().forEach(System.out::println);
        integerList.stream().filter(num -> num != null).distinct().map(a -> a*2).sorted().forEach( e -> System.out.print(e + ","));

    }

}
