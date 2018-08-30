package reference;

import java.util.ArrayList;
import java.util.List;

/**
 * @Package Name : ${PACKAG_NAME}
 * @Author : 1766318593@qq.com
 * @Creation Date : 2018年06月12日上午11:19
 * @Function : todo
 */
public class TestMain {

    static void add(List<Integer> list){
        list.add(100);
    }

    static void append(String str){
        str="sfsf";
    }
    static void addNum(int a){
        a=a+10;
    }

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0;i <10 ;++i){
            list.add(i);
        }

        add(list);

        for (Integer i:list){
            System.err.print(i+"  ,");
        }
        System.err.println("");
        System.err.println("*********************");


        String a="A";
        append(a);
        System.err.println(a);


        int num = 5;
        addNum(num);
        System.err.println(num);


    }

}
