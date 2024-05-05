package proxy.cglib;

import org.springframework.cglib.proxy.Enhancer;

/**
 * @Package Name : ${PACKAG_NAME}
 * @Author : 1766318593@qq.com
 * @Creation Date : 2018年11月19日下午10:14
 * @Function : todo
 */
public class CglibProxyTest {

    public static void main(String[] args) {


        // 2. 然后在需要使用HelloConcrete的时候，通过CGLIB动态代理获取代理对象。
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(HelloConcrete.class);

        enhancer.setCallback(new MyMethodInterceptor());

        HelloConcrete hello = (HelloConcrete) enhancer.create();


        System.out.println(hello.sayHello("I love you!"));
    }

}
