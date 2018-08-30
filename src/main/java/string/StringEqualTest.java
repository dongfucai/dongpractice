package string;

/**
 * @Package Name : ${PACKAG_NAME}
 * @Author : 1766318593@qq.com
 * @Creation Date : 2018年07月29日下午8:54
 * @Function : todo
 */
public class StringEqualTest {

    public static void main(String[] args) {


        /**
         * 补充：解答上面的面试题需要清除两点：1. String对象的intern方法会得到字符串对象在常量池中对应的版本的引用
         * （如果常量池中有一个字符串与String对象的equals结果是true），如果常量池中没有对应的字符串，
         * 则该字符串将被添加到常量池中，然后返回常量池中字符串的引用；
         * 2. 字符串的+操作其本质是创建了StringBuilder对象进行append操作，
         * 然后将拼接后的StringBuilder对象用toString方法处理成String对象，
         * 这一点可以用javap -c StringEqualTest.class命令获得class文件对应的JVM字节码指令就可以看出来。
         */

        String s1 = "Programming";
        String s2 = new String("Programming");
        String s3 = "Program";
        String s4 = "ming";
        String s5 = "Program" + "ming";
        String s6 = s3 + s4;
        System.out.println(s1 == s2); //false
        System.out.println(s1 == s5);// true
        System.out.println(s1 == s6);// false  A：false，因为s2+s3实际上是使用StringBuilder.append来完成，会生成不同的对象。
                                   // but s3 s4 加上final关键字后  在编译后直接变成对应的值，s6="Program"+"ming"

        System.out.println(s1 == s6.intern()); // true
        System.out.println(s2 == s2.intern());// false


        System.out.println(s1 == s2.intern()); // true


        /**
         * 补充2：运行时常量池相当于Class文件常量池具有动态性，
         * Java语言并不要求常量一定只有编译期间才能产生，
         * 运行期间也可以将新的常量放入池中，String类的intern()方法就是这样的。
         */

        String str = new String("hello");

        //上面的语句中变量str放在栈上，用new创建出来的字符串对象放在堆上，而"hello"这个字面量是放在方法区的。

    }

}
