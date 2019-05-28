package guava.eventbus;

/**
 * @Package Name : ${PACKAG_NAME}
 * @Author : dongfucai@meituan.com
 * @Creation Date : 2019年03月31日下午11:09
 * @Function : todo
 */
public class TestEvent {
    private final int message;
    public TestEvent(int message) {
        this.message = message;
        System.out.println("event message:"+message);
    }
    public int getMessage() {
        return message;
    }
}