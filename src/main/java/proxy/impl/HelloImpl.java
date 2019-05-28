package proxy.impl;

import proxy.Hello;

/**
 * @Package Name : ${PACKAG_NAME}
 * @Author : 1766318593@qq.com
 * @Creation Date : 2018年11月19日下午9:31
 * @Function : todo
 */
public class HelloImpl implements Hello {
    @Override
    public String sayHello(String str) {
        return "HelloImp: " + str;
    }

}
