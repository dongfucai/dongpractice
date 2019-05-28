package gc.GCLogDemo;

/**
 * @Package Name : ${PACKAG_NAME}
 * @Author : dongfucai@meituan.com
 * @Creation Date : 2019年03月07日下午10:15
 * @Function : todo
 */
public class GCLogDemo {

    public static void main(String[] args) {
        int _1m = 1024 * 1024;
        byte[] data = new byte[_1m];
        // 将data置为null即让它成为垃圾
        data = null;
        // 通知垃圾回收器回收垃圾
        System.gc();
        System.out.println(System.getProperty("sun.arch.data.model"));

    }

}
