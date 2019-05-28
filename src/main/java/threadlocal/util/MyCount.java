package threadlocal.util;

/**
 * @Package Name : ${PACKAG_NAME}
 * @Author : 1766318593@qq.com
 * @Creation Date : 2018年11月17日下午5:31
 * @Function : todo
 */
public class MyCount {

    public static class Counter {
        public static ThreadLocal<StringBuilder> counter = new ThreadLocal<StringBuilder>() {
            @Override
            protected StringBuilder initialValue() {
                return new StringBuilder();
            }
        };
    }

}
