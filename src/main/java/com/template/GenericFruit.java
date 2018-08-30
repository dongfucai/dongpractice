package com.template;


class Fruit{
    @Override
    public String toString() {
        return "fruit";
    }
}

class Apple extends Fruit {
    @Override
    public String toString() {
        return "apple";
    }
}

class Person{
    @Override
    public String toString() {
        return "Person";
    }
}

class GenerateTest<T>{
    public void show_1(T t){
        System.out.println(t.toString());
    }

    //在泛型类中声明了一个泛型方法，使用泛型E，这种泛型E可以为任意类型。可以类型与T相同，也可以不同。
    //由于泛型方法在声明的时候会声明泛型<E>，因此即使在泛型类中并未声明泛型，编译器也能够正确识别泛型方法中识别的泛型。
    public <E> void show_3(E t){
        System.out.println(t.toString());
    }

    //在泛型类中声明了一个泛型方法，使用泛型T，注意这个T是一种全新的类型，可以与泛型类中声明的T不是同一种类型。
    public <T> void show_2(T t){
        System.out.println(t.toString());
    }
}

public class GenericFruit {

    //泛型方法可变参数
    public static <T> void printMsg(T ... args){

        for(T t : args){
            System.out.println(t);
        }
    }

    /**
     * 4.5 泛型通配符
     *
     * 我们知道Ingeter是Number的一个子类，
     * 同时在特性章节中我们也验证过Generic<Ingeter>与Generic<Number>实际上是相同的一种基本类型。
     * 那么问题来了，在使用Generic<Number>作为形参的方法中，能否使用Generic<Ingeter>的实例传入呢？
     * 在逻辑上类似于Generic<Number>和Generic<Ingeter>是否可以看成具有父子关系的泛型类型呢？
     * @param obj
     */
    // 为泛型添加上下边界， 即传入的类型参数必须是指定类型的自类型
    public static void showkeyvalue1(Generic<? extends Number> obj){
        System.out.println("泛型测试  + " + obj.getKey());
    }


    public static void main(String[] args) {

        //泛型方法可变参数
        printMsg("34",3533,"sefe",45644);

        //为泛型添加上下边界  泛型通配符
        // ~ 它只是“与声明相同”的简写。一些IDE，例如Intellij也使用这个。
        Generic<String> g1 = new Generic<String>("1111");
        Generic<Integer> g2 = new Generic<Integer>(2222);
        Generic<Float> g3 = new Generic<Float>(2.4f);
        Generic<Double> g4 = new Generic<Double>(2.56);

        // string 不是 Number 的子类 会报错
        //showkeyvalue1(g1);

        showkeyvalue1(g2);
        showkeyvalue1(g3);
        showkeyvalue1(g4);


        Apple apple = new Apple();
        Person person = new Person();

        GenerateTest<Fruit> generateTest = new GenerateTest<Fruit>();
        //apple是Fruit的子类，所以这里可以
        generateTest.show_1(apple);


        //编译器会报错，因为泛型类型实参指定的是Fruit，而传入的实参类是Person
        //generateTest.show_1(person);

        //使用这两个方法都可以成功
        generateTest.show_2(apple);
        generateTest.show_2(person);


        //使用这两个方法也都可以成功
        generateTest.show_3(apple);
        generateTest.show_3(person);
    }
}
