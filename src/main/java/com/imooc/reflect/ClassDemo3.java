package com.imooc.reflect;

public class ClassDemo3 {
    public static void main(String[] args){

        String str="hellworld";
        ClassUtil.printClassMessage(str);

        // 任何类的信息都拿到通过反射
       // Integer n1=1;
       // ClassUtil.printClassMessage(n1);
    }
}
