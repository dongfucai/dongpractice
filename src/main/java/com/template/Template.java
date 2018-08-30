package com.template;


import java.util.ArrayList;
import java.util.List;

public class Template {
    /**
     * 泛型方法的基本介绍
     * @param tClass 传入的泛型实参
     * @return T 返回值为T类型
     * 说明：
     *     1）public 与 返回值中间<T>非常重要，可以理解为声明此方法为泛型方法。
     *     2）只有声明了<T>的方法才是泛型方法，泛型类中的使用了泛型的成员方法并不是泛型方法。
     *     3）<T>表明该方法将使用泛型类型T，此时才可以在方法中使用泛型类型T。
     *     4）与泛型类的定义一样，此处T可以随便写为任意标识，常见的如T、E、K、V等形式的参数常用于表示泛型。
     */



    public static <T> T genericMethod(Class<T> tClass) throws InstantiationException,IllegalAccessException {
        T instance = tClass.newInstance();
        return instance;
    }


    /**
     * 通过上面的例子可以证明，在编译之后程序会采取去泛型化的措施。也就是说Java中的泛型，
     * 只在编译阶段有效。在编译过程中，正确检验泛型结果后，会将泛型的相关信息擦出，
     * 并且在对象进入和离开方法的边界处添加类型检查和类型转换的方法。也就是说，泛型信息不会进入到运行时阶段。
     */
    public  static void genericCompile(){
        List<String> sArr= new ArrayList<String>();
        List<Integer> iArr= new ArrayList<Integer>();

        Class classStringArrayList = sArr.getClass();
        Class classIntergeArrayList = iArr.getClass();

        if(classIntergeArrayList.equals(classStringArrayList)){
            System.out.println("泛型测试 类型相同");
        }
    }
    public static void main(String[] args){

        genericCompile(); // 测试泛型只在编译期间 起作用

        try {
            Object obj = genericMethod(Class.forName("com.log4j.Log4jTest"));
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


        Generic<Integer> generic=new Generic<Integer>(122423);

        // 泛型不一定传入参数  在不传入泛型实参的方法的话，    在泛型类中使用 可以任何类型

        Generic gA=new Generic(222223);
        Generic gB=new Generic("sfdsf");
        System.out.println(gA.getKey());
        System.out.println(gB.getKey());



        List arrayList= new ArrayList();
        arrayList.add("aaaa");
        arrayList.add(100);

//        List<String> arr=new ArrayList<String>();
//        arr.add("aaaa");
//        arr.add(3334);  // compile error

//
//        for(int i=0;i<arrayList.size();++i){
//            String item=(String)arrayList.get(i);  // 运行期间出错
//            System.out.println("泛型编程   ="+ item);
//
//        }



    }
}
