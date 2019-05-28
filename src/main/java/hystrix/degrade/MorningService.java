package hystrix.degrade;

/**
 * @Package Name : ${PACKAG_NAME}
 * @Author : 1766318593@qq.com
 * @Creation Date : 2019年04月03日上午11:20
 * @Function : todo
 */
public class MorningService {

    /**
     * 超时
     */
    public void timeout() {
        int j = 0;
        while (true) {
            j++;
        }
    }

    public static void main(String[] args) {

    }

}
