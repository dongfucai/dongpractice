package volatile1;

/**
 * @Package Name : ${PACKAG_NAME}
 * @Author : dongfucai@meituan.com
 * @Creation Date : 2018年05月11日下午6:26
 * @Function : todo
 */
public class LazySingleton {

    private static  volatile LazySingleton instance=null;

    public static LazySingleton getInstance(){
        if(instance==null){
            instance=new LazySingleton();
        }
        return instance;
    }

    public static void main(String[] args) {

        System.out.println( LazySingleton.getInstance());
    }

}
