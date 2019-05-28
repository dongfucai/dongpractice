package integercompare;

/**
 * @Package Name : ${PACKAG_NAME}
 * @Author : 1766318593@qq.com
 * @Creation Date : 2018年06月12日下午3:26
 * @Function : todo
 */
public class IntegerTest {

    public static void 打印(){
        System.out.println("fdfgdg");
    }

    /**
     * 问题：一个类能拥有多个main方法吗？
     * 答案：可以，但只能有一个main方法拥有以下签名：
     *
     * public static void main(String[] args) {}
     * 否则程序将无法通过编译。编译器会警告你main方法已经存在。
     * @param d
     */
    public void main(Integer d) {

    }

    public static void main(String[] args) {

        System.out.println(args.length);
        打印();
        Double d1 = 100.0;
        Double d2 = 100.0;
        Double d3 = 200.0;
        Double d4 = 200.0;

        System.out.println(d1 == d2);
        System.out.println(d3 == d4);


        Integer i1=100;
        Integer i2=100;

        Integer i3=200;
        Integer i4=200;

        int i5 = 200;
        int i6 = 100;

        Integer i7 = new Integer(200);
        Integer i8 = new Integer(200);
        Integer i9 = new Integer(100);
        System.out.println(i9 == i1);
        System.out.println(i7 == i8);
        System.out.println(i7 == i3);
        /*
        产生这样的结果的原因是：Byte、Short、Integer、Long、Char这几个装箱类的valueOf()方法是以128位分界线做了缓存的，
        假如是128以下且-128以上的值是会取缓存里面的引用的，以Integer为例，其valueOf(int i)的源代码为：
        public static Integer valueOf(int i) {
    final int offset = 128;
    if (i >= -128 && i <= 127) { // must cache
        return IntegerCache.cache[i + offset];
    }
        return new Integer(i);
    }




         */
        System.out.println(i1==i2);
        System.out.println(i3==i4);

        System.out.println(i1 == i6);
        System.out.println(i3 == i5);
    }

}
