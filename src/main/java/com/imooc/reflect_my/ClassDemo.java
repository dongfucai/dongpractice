package com.imooc.reflect_my;

/**
 * @Package Name : ${PACKAG_NAME}
 * @Author : dongfucai@meituan.com
 * @Creation Date : 2019年01月06日下午12:07
 * @Function : todo
 */
public class ClassDemo {

    public Class<?> aClass;

    public String temp = "3453";
    public static void main(String[] args) throws Exception{


        new ClassDemo().getClass().newInstance();

        try {
            Class clazz = Class.forName("com.imooc.reflect_my.ClassDemo");
            ClassDemo classDemo = (ClassDemo) clazz.newInstance();
            System.out.println(classDemo.temp);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

}
