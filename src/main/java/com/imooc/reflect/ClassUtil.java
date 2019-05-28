package com.imooc.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ClassUtil {
    /**
     * 打印类的信息，包括类的成员的函数，成员变量
     * @param obj
     */
    public static void printClassMessage(Object obj){
        // 获取类的信息，首先要获取类的类类型   如果传进来的是类的实例，可以通过getclass方法获取
        Class c = obj.getClass();// 传递那个子类的对象，c就是该子类的类类型
        // 获取类的名称
        System.out.println("类的名称"+c.getName());
        // 万事万物都是对象，方法也是对象，java中方法是Method 的对象

        /**
         * Method 类，方法对象
         * 一个成员方法是以一个Method对象
         * getMethods 方法获取的所有pulic的函数，包括父类继承而来的
         * getDeclaredMethods 获取的是所有该类自己声名的方法，不问访问权限
         */
        Method[] ms=c.getMethods(); //c.getDeclaredMethods()
        for(int i=0;i<ms.length;i++){
            // 得到返回值类型的类类型
            /*
             比如 返回值为int 得到的是int.class
                       String      String.class
             */
            Class returnType= ms[i].getReturnType();
            System.out.println(ms[i].getGenericReturnType() + "  dongfucai");
            System.out.print(returnType.getName()+" ");
            // 获得方法名称
            System.out.print(ms[i].getName()+"(");

            // 获取参数类型
            Class[] praramType = ms[i].getParameterTypes();

            for(Class class1:praramType){
                System.out.print(class1.getName()+",");
            }
            System.out.println(")");

        }


    }

    /*
     获取成员变量
     */
    public static void printFieldMessage(Object obj) {
    /*
      成员变量也是对象
      java.lang.reflect.Field
      Field 类封装了 有关成员变量的操作
      getField 方法获取的是所有pulic 成员变量的信息
     */

    // 成员的方法和变量  都可以找到注解
        Class c = obj.getClass();

        // Field[] fs=c.getFields();
        Field[] fs = c.getDeclaredFields();

        for (Field field : fs) {
            // 得到成员变量的类型的类类型
            Class fieldType = field.getType();
            String typename = fieldType.getName();

            String fileName = field.getName();

            System.out.println(typename + " " + fileName);

        }
    }

    /**
     *  打印对象的构造函数信息
     */
    public static void printConMessage(Object obj){
        Class c=obj.getClass();



        /*
             构造函数也是对象
             java.lang.Constructor 中封装了构造函数信息
             getConstructors 所有有构造函数
         */
        //Constructor[] cs=c.getConstructors();
        Constructor[] cs=c.getDeclaredConstructors();

        for(Constructor constructor:cs){
            System.out.print(constructor.getName()+"(");

            //获取参数列表的类类型 数组
            Class[] paramTypes = constructor.getParameterTypes();
            for(Class class1:paramTypes){
                System.out.print(class1.getName()+",");
            }
            System.out.println(")");
        }


    }
}
