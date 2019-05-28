package proxy.dynamic;

import proxy.Hello;
import proxy.impl.HelloImpl;

import java.lang.reflect.Proxy;

/**
 * @Package Name : ${PACKAG_NAME}
 * @Author : 1766318593@qq.com
 * @Creation Date : 2018年11月19日下午9:50
 * @Function : todo
 */
public class ProxyTest {

    public static void main(String[] args) {

        // 2. 然后在需要使用Hello的时候，通过JDK动态代理获取Hello的代理对象。
        Hello hello = (Hello)Proxy.newProxyInstance(
                Hello.class.getClassLoader(), // 1. 类加载器
                new Class<?>[] {Hello.class}, // 2. 代理需要实现的接口，可以有多个
                new LogInvocationHandler(new HelloImpl()));// 3. 方法调用的实际处理者
        System.out.println(hello.sayHello("I love you!"));
    }

}
