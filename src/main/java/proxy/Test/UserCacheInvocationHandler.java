package proxy.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @Author dongfucai/1766318593@qq.com
 * @Description //TODO
 * @Date 2021/4/21 下午7:51
 * @Version 1.0
 **/

public class UserCacheInvocationHandler implements InvocationHandler {

    private UserService userService;

    public UserCacheInvocationHandler(UserService userService) {
        this.userService = userService;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//        if(Cache.userExist(args[0])) {
//           return Cache.getUser；
//        }
        return method.invoke(userService, args);
    }
}
