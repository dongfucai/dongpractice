package clone;

/**
 * @Package Name : ${PACKAG_NAME}
 * @Author : 1766318593@qq.com
 * @Creation Date : 2018年06月12日下午3:44
 * @Function : todo
 */
/*
Cloneable和Serializable一样都是标记型接口，它们内部都没有方法和属性，implements Cloneable表示该对象能被克隆，
能使用Object.clone()方法。
如果没有implements Cloneable的类调用Object.clone()方法就会抛出CloneNotSupportedException。
 */



public class CloneDemo implements Cloneable {

    int x;
    String str="sdfs";
    String str1 = str;


    public static void main(String[] args) throws CloneNotSupportedException {

        CloneDemo cd = new CloneDemo();
        cd.x=5;

        System.out.printf("cd.x= %d %n",cd.x);
        System.out.println(cd.str1.hashCode());
        System.out.println(cd.hashCode());



        CloneDemo cd2 = (CloneDemo)cd.clone();
        System.out.printf("cd2.x= %d %n",cd2.x);
        System.out.println(cd2.str1.hashCode());
        System.out.println(cd2.hashCode());



    }

}
