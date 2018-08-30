package interview;

/**
 * @Package Name : ${PACKAG_NAME}
 * @Author : 1766318593@qq.com
 * @Creation Date : 2018年07月30日上午11:44
 * @Function : todo
 */
public class Outer {


    class Inner{}

   // public static void foo() { new Inner();};

    public void  bar() {new Inner();}

    public static void main(String[] args) {

        //new Inner();

        new Outer().new Inner();
    }

}
