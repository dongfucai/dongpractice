package spring.bean.util;

import org.springframework.beans.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;

/**
 * @Package Name : ${PACKAG_NAME}
 * @Author : 1766318593@qq.com
 * @Creation Date : 2018年10月30日下午4:54
 * @Function : todo
 */
public class BeanUtilTest {


    public static void main(String[] args) throws IllegalAccessException, InvocationTargetException{

        Person per = new Person();
        Student stu = new Student();
        Own own = new Own();

        own.setAge(10L);

        per.setName("zhangsan");
        per.setSex("男");
        per.setAge(20);
        per.setBirthday(new Date());

        stu.setName("wuangwu");
        stu.setAddress("北京市");


        Own own1 = null;
        BeanUtils.copyProperties(own, stu);
        BeanUtils.copyProperties(per, stu);
//        try {
//            BeanUtils.copyProperties(stu, per);
//
//        } catch (IllegalAccessException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        } catch (InvocationTargetException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
        System.out.println(stu.getName());
        System.out.println(stu.getAge());
        System.out.println(stu.getAddress());
        System.out.println(stu.getBirthday());




    }

}
