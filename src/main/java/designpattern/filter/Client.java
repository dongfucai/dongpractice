package designpattern.filter;

/**
 * @Package Name : ${PACKAG_NAME}
 * @Author : dongfucai@meituan.com
 * @Creation Date : 2018年07月14日下午6:32
 * @Function : todo
 */
public class Client {

    public static void main(String[] args) {


        Request req = new Request();
        Response res = new Response();

        req.requestStr = "这是我的一个敏感链接<a>优酷</a>";

        res.respnseStr = "response";


        FilterChain fc = new FilterChain();

        fc.addfilter(new HTMLFilter());
        fc.addfilter(new SensitiveFilter());

        fc.doFilter(req, res, fc);


        System.out.println(req.requestStr);
        System.out.println(res.respnseStr);


    }
}