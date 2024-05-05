package com.java8;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * @Author dongfucai/1766318593@qq.com
 * @Description //TODO
 * @Date 2023/2/5 下午6:25
 * @Version 1.0
 **/

public class Java8Test {


    public static void main(String[] args) {

        Predicate<String> predicate1 = n -> n.startsWith("A");
        Predicate<String> predicate2 = n -> n.contains("2");

        List<String> strList = Arrays.asList("A111","B222","A1234","A2345");
        strList.stream().filter(predicate1).filter(predicate2).forEach(System.out::println);

        //strList.stream().filter(predicate1).and(predicate2).forEach(System.out::println);


        Predicate<String> predicate3 = n -> n.startsWith("A")&&n.contains("2");
        strList.stream().filter(predicate3).forEach(System.out::println);

        Predicate<String> predicate4 = n -> { return  n.startsWith("A")&&n.contains("2");};
        strList.stream().filter(predicate4).forEach(System.out::println);


    }
}
