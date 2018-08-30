package com.imooc.reflect;
/*
  为什么要用方法 的发射

 */

import java.lang.reflect.Method;
import java.util.ArrayList;

/*
   通过 Class 和Method 来认识范型的本质

 */
public class MethodDemo4 {
      public static void main(String[] args){
          ArrayList list=new ArrayList();
          // 能放任何类型

          ArrayList<String> list1 = new ArrayList<String>();
          list1.add("sfs");
         // list1.add(30); // cuowu

          Class c1=list.getClass();
          Class c2=list1.getClass();
          System.out.println(c1==c2);

          // 反射的操作都是编译后的操作，都是运行的操作

          // c1=c2 结果返回true 说明编译后集合的泛型是去泛型化的
          // java 中集合的泛型，是防止错误输入的，只在编译阶段有效
          // 绕过编译就无效来了
          /*
            验证：我们可以通过方法的发射来操作，绕过编译
           */

          Method m= null;
          try {
              m = c2.getMethod("add",Object.class);
              m.invoke(list1,20);// 绕过了泛型
              System.out.println(list1.size());
              System.out.println(list1);
//              for(String str:list1){  // 这时候就不能用forecah遍历了
//                  System.out.println(str);
//              }
//

          } catch (Exception e) {
              e.printStackTrace();
          }




      }

}
