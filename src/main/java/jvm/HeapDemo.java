package jvm;

/**
 * @Package Name : ${PACKAG_NAME}
 * @Author : 1766318593@qq.com
 * @Creation Date : 2018年05月11日上午12:07
 * @Function : todo
 */
public class HeapDemo {

    public static void main(String[] args) {
             byte[] b=null;
             for (int i=0;i<10;++i){
                 b = new byte[1*1024*1024];
             }
    }

}
