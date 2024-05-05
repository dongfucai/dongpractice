package inner;

/**
 * @Author dongfucai/1766318593@qq.com
 * @Description //TODO
 * @Date 2022/6/6 下午10:21
 * @Version 1.0
 **/

public class InnerClassTest {

    public  int x = 0;

    interface ClassInn {
        void check(int x);
    }

    ClassInn classInn = new ClassInn() {

        public int x = 1;
        public static final String finalStr = "hello world";

        public static final String str = "hello world";

//        public static void  aa(){
//
//        }

        public void extraMethod() {}

        @Override
        public void check(int x) {
            System.out.println(finalStr);
        }
    };

    public static void main(String[] args) {
        InnerClassTest i = new InnerClassTest();

        i.classInn.check(1);

    }

}
