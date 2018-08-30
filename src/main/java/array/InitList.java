package array;

import com.google.common.collect.Lists;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Package Name : ${PACKAG_NAME}
 * @Author : dongfucai@meituan.com
 * @Creation Date : 2018年08月15日下午4:37
 * @Function : todo
 */
public class InitList {

    public static void main(String[] args) {


        /**
         * jdk 2
         */

        List<String> list2 = Arrays.asList("one", "two", "three");


        /**
         * jdk 8
         */

        List<String> list8 = Stream.of("one", "two", "three").collect(Collectors.toList());


        /**
         * jdk 9
         */
       // List<String> list = List.of("one", "two", "three");

        /**
         * guava
         */

        List<String> listg = Lists.newArrayList("one", "two", "three");


        System.out.println(list2);
        System.out.println(list8);
        System.out.println(listg);


    }

}
