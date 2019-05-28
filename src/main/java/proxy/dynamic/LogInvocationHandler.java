package proxy.dynamic;

import proxy.Hello;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @Package Name : ${PACKAG_NAME}
 * @Author : 1766318593@qq.com
 * @Creation Date : 2018年11月19日下午9:46
 * @Function : todo
 *
 * // 1. 首先实现一个InvocationHandler，方法调用会被转发到该类的invoke()方法。
 */
public class LogInvocationHandler implements InvocationHandler {

    private Hello hello;
    public LogInvocationHandler(Hello hello) {
        this.hello = hello;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if("sayHello".equals(method.getName())) {
            System.out.println("You said: " + Arrays.toString(args));
            //logger.info("You said: " + Arrays.toString(args));
        }
        return method.invoke(hello, args);
    }

}
