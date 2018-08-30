package jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * @Package Name : ${PACKAG_NAME}
 * @Author : 1766318593@qq.com
 * @Creation Date : 2018年05月09日下午11:43
 * @Function : todo
 */
public class Hello {
    private final static int BYTE_SIZE = 4 * 1024 * 1024;

    public static void main(String[] args) {

        List<Object> List = new ArrayList<Object>();
        for(int i = 0 ; i < 10 ; i ++) {
            List.add(new byte[BYTE_SIZE]);
            System.out.println(i);

        }

    }

}
