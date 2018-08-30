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

}
