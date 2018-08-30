package trycatchfinaly;

/**
 * @Package Name : ${PACKAG_NAME}
 * @Author : dongfucai@meituan.com
 * @Creation Date : 2018年08月27日下午6:12
 * @Function : todo
 */
public class NoException {


    public static int NoTest(){

        int i = 10;

        try {
            System.out.println("i in try block is "+i);
            return --i;
        } catch (Exception e) {
            e.printStackTrace();
            --i;
            System.out.println("i in catch - form try block is"+i);
            return --i;
        } finally {

            System.out.println("i in finally - from try or catch block is"+i);
            return --i;

        }


    }
    public static void main(String[] args) {

        System.out.println(NoTest());

    }

}
