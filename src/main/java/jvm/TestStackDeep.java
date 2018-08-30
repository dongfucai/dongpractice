package jvm;

/**
 * @Package Name : ${PACKAG_NAME}
 * @Author : dongfucai@meituan.com
 * @Creation Date : 2018年05月15日上午12:28
 * @Function : todo
 */
public class TestStackDeep {

    private static int count=0;

    public static void recursion(long a,long b,long c){
        long e=2,f=2,g=4,h=34,i=34,k=34,hh=34;
        count++;
        recursion(a,b,c);
    }

    public static void main(String[] args) {

        try {
            recursion(0L,0L,0L);
        } catch (Throwable e) {
            System.out.println(count);
            e.printStackTrace();
        }
    }

}
