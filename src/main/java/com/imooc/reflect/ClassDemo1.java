package com.imooc.reflect;

/*
Class也是类，它的实例对象是一个个的类，这一个个的类都有类名啊，都有方法啊，都有属性啊等等，
所以就抽象出了一个Class类来管理这些一个个类的相关。因为一个程序中类肯定很多，
所以用Class类来管理
 */


/*
1 Class 类
  普通的数据类型 不是对象
  static 成员不是对象
 */
/*
  类是谁的对象呢？
  类是对象，类是java.lang.Class类的实例对象
   比如 student 类 是 java.lang.Class类的实力对象
 */
/*
       Class.forName("类的全称")
       不仅表示了 ，类的类类型，还代表了 动态加载类
 */
public class ClassDemo1 {

      public static  void main(String[]args){
          // Foo 实例对象如何表示
          Foo foo1 = new Foo();//
          // Foo 这个类的也是一个实例对象，Class类的实例对象如何表示呢？
          // 任何一个类都是Class 的实例对象

          // 1 实际在告诉我们任何一个类都有一个隐含的静态成员变量class
          Class c1=Foo.class;
          // 2 已经知道该类的对象 通过getClass方法
          Class c2 = foo1.getClass();
          // 官网 c1,c2 表示Foo类的类类型
          /*
            类也对象，是Class类的实例对象
            这个对象我们称为该类的类类型
           */

          // 不管c1 or c2 都代表了Foo类的类类型 ，一个类只可能是Class类的一个实例对象
          System.out.println(c1==c2);

          //3
          Class c3=null;
          try {
              c3 = Class.forName("com.imooc.reflect.Foo");
          }catch (ClassNotFoundException e){
              e.printStackTrace();
          }
          System.out.println(c2==c3);


          // 我们完全可以通过该类的类类型创建该类的对象实例，通过c1 or c2 or c3 创建Foo 的实例对象

          try {
              Foo foo =(Foo)c1.newInstance();//
              foo.print();
          } catch (InstantiationException e) {
              e.printStackTrace();
          } catch (IllegalAccessException e) {
              e.printStackTrace();
          }

      }

}

class Foo {
    public void print(){
        System.out.println("sfdsf");
    }
}