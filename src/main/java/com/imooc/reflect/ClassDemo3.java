package com.imooc.reflect;

import clone.CloneDemo;
import com.imooc.impl.MyImpl;
import com.imooc.reflect_my.ClassDemo;
import proxy.Test.UserService;

public class ClassDemo3 {
    public static void main(String[] args){

        String str="hellworld";


        try {
            Class clazz = Class.forName("com.imooc.impl.MyImpl");
            MyImpl myimpl = (MyImpl) clazz.newInstance();
            ClassUtil.printClassMessage(myimpl);
        } catch (Exception e) {
            e.printStackTrace();
        }





        // 任何类的信息都拿到通过反射
       // Integer n1=1;
       // ClassUtil.printClassMessage(n1);
    }
}
