package PermOOM;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @Package Name : ${PACKAG_NAME}
 * @Author : 1766318593@qq.com
 * @Creation Date : 2018年07月07日下午7:09
 * @Function : todo
 */
public class PermOOM {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        while (true){
            list.add(UUID.randomUUID().toString().intern());
        }
    }

}
