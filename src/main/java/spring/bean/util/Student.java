package spring.bean.util;

import lombok.Data;

import java.util.Date;

/**
 * @Package Name : ${PACKAG_NAME}
 * @Author : 1766318593@qq.com
 * @Creation Date : 2018年10月30日下午4:55
 * @Function : todo
 */
@Data
public class Student {

    private String name;
    private Long age;
    private String address;
    private Date birthday;

    public static void main(String[] args) {

    }

}
