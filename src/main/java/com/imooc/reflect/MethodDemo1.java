package com.imooc.reflect;


import java.lang.reflect.Method;

public class MethodDemo1 {

    public static void main(String[] args){

        // 获取 print（int, int） 方法
        // 1 要获取一个方法就是获取类的信息，获取类的信息


        A a1=new A();
        Class c=a1.getClass();

        /*
          2 获取方法 名称和参数列表决定
          getmethod 获取pulic 的方法
         */

        try {
            //Method m=c.getMethod("print",new Class[]{int.class,int.class});
            Method m=c.getMethod("print",int.class,int.class);

            // 方法的反射  作用是用m对象来进行方法调用
            // 以前 a1.print(10,20)
            // 方法如果没有返回值 返回null 有返回值返回具体的返回值
           // Object o = m.invoke(a1,new Object[]{10,20});

            Object o = m.invoke(a1,10,20);

            System.out.println("===============");
            Method m1=c.getMethod("print",String.class,String.class);

            o=m1.invoke(a1,"hello","world");



        } catch (Exception e) {
            e.printStackTrace();
        }



    }
}

class A{
    public void print(int a,int b){
        System.out.println(a+b);
    }

    public void print(String a, String b){
        System.out.println(a.toUpperCase()+" "+b.toLowerCase());
    }
}