package proxy;

import proxy.impl.HelloImpl;

/**
 * @Package Name : ${PACKAG_NAME}
 * @Author : 1766318593@qq.com
 * @Creation Date : 2018年11月19日下午9:30
 * @Function : todo
 */
public class StaticProxiedHello implements Hello {

    private Hello hello = new HelloImpl();

    @Override
    public String sayHello(String str) {
        //logger.info("You said: " + str);
        System.out.println("you said " + str);
        return hello.sayHello(str);
    }
}
