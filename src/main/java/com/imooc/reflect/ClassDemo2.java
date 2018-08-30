package com.imooc.reflect;

/*
 4 基本的数据类型 void 关键字 都存在类类型
 5 Class 类的基本信息
 */

public class ClassDemo2 {
   public static void main(String[] arg) {
       Class c1 = int.class;// int 的类类型
       Class c2 = String.class; // String 的类类型 string 的字节码
       Class c3 = double.class;
       Class c4 = Double.class;
       Class c5 = void.class;

       System.out.println(c1.getName()); //
       System.out.println(c2.getName()); // 打印类的全称 名称

   }
}
