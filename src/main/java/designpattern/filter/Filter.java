package designpattern.filter;

/**
 * @Package Name : ${PACKAG_NAME}
 * @Author : 1766318593@qq.com
 * @Creation Date : 2018年07月10日下午3:31
 * @Function : todo
 */

// 过滤的接口
public interface Filter {

// 有req 有 res 有 过滤链
    public void doFilter(Request req,Response res,FilterChain fc);

}
