package Exception;

/**
 * @Package Name : ${PACKAG_NAME}
 * @Author : 1766318593@qq.com
 * @Creation Date : 2018年06月12日下午3:40
 * @Function : todo
 */
public class ExceptionTest {

    //public static void function() throws NumberFormatException{
    // 不写throws 也可以 同样抛出异常
    // throws是方法可能抛出异常的声明。(用在声明方法时，表示该方法可能要抛出异常)


    public static void function() {

        String s = "abc";
        System.out.println(Double.parseDouble(s));
    }


    public static void main(String[] args) {

        try {
            function();
        } catch (Exception e) {
            System.err.println("非数据类型不能转换。");
            //e.printStackTrace();
        }finally {
            System.out.println("hsdhfkj");  // xian dayin
        }


    }

    public static boolean catchMethod() {
                System.out.print("call catchMethod and return  --->>  ");
                return false;
    }
     // finally后续处理工作
             public static void finallyMethod() {
                System.out.println();
                System.out.print("call finallyMethod and do something  --->>  ");
           }

     public static boolean catchTest() {
                try {
                        int i = 10 / 0;   // 抛出 Exception，后续处理被拒绝
                        System.out.println("i vaule is : " + i);
                        return true;    // Exception 已经抛出，没有获得被执行的机会
                    } catch (Exception e) {
                        System.out.println(" -- Exception --");
                        return catchMethod();    // Exception 抛出，获得了调用方法并返回方法值的机会
                    }
    }

}
