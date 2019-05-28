package guava.eventbus;

import com.google.common.eventbus.EventBus;

/**
 * @Package Name : ${PACKAG_NAME}
 * @Author : dongfucai@meituan.com
 * @Creation Date : 2019年03月31日下午11:10
 * @Function : todo
 */
public class Test {

    public static void main(String[] args) {

        EventBus eventBus = new EventBus("test");
        EventListener listener = new EventListener();

        eventBus.register(listener);

        eventBus.post(new TestEvent(200));
        eventBus.post(new TestEvent(300));
        eventBus.post(new TestEvent(400));

        System.out.println("LastMessage:"+listener.getLastMessage());
        ;

    }

}
