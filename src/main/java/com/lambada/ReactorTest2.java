package com.lambada;

import com.google.common.collect.Maps;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Author dongfucai/1766318593@qq.com
 * @Description //TODO
 * @Date 2020/12/12 上午11:40
 * @Version 1.0
 **/

public class ReactorTest2 {


    public static void main(String[] args) {

        long s = System.currentTimeMillis();

        System.out.println(s);


        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("this is a ");
            }
        });

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ArrayList<Integer> arr = new ArrayList<Integer>(Arrays.asList(6, 15, 3, 80));

        arr.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });

        arr.forEach((item) -> {
            System.out.println(item);
        });

        arr.sort((x,y) -> y - x);

        arr.forEach((item) -> {
            System.out.println(item);
        });



        Map<String, String> mp = Maps.newHashMap();
        mp.put("bbb","1111");
        mp.put("aaa", "2222");

        mp.forEach((k, v) -> {
            System.out.println("k:" + k + ",v:" + v);
        });
        mp.entrySet().forEach((item) -> {
            System.out.println(item.getKey() + "," + item.getValue());
        });


        List<Integer> aaa = arr.stream().map(x -> 10 * x).flatMap(x -> Stream.of(x, x + 1, x + 2)).filter(x -> x % 3 == 0).collect(Collectors.toList());

        aaa.forEach( x -> {
            System.out.println("aaa:" + x);
        });


        arr.stream().map(x -> 10 * x).flatMap(x -> Stream.of(x, x + 1, x + 2)).filter( x -> x % 3 == 0).forEach(System.out::println);



    }
}
