package guava.eventbus;

import com.google.common.eventbus.Subscribe;

/**
 * @Package Name : ${PACKAG_NAME}
 * @Author : dongfucai@meituan.com
 * @Creation Date : 2019年03月31日下午11:09
 * @Function : todo
 */
public class EventListener {
    public int lastMessage = 0;

    @Subscribe
    public void listen(TestEvent event) {
        lastMessage = event.getMessage();
        System.out.println("Message:"+lastMessage);
    }

    public int getLastMessage() {
        return lastMessage;
    }
}