package designpattern.filter;

/**
 * @Package Name : ${PACKAG_NAME}
 * @Author : 1766318593@qq.com
 * @Creation Date : 2018年07月14日下午6:29
 * @Function : todo
 */
public class SensitiveFilter implements Filter{



    @Override
    public void doFilter(Request req,Response res,FilterChain fc){

        req.requestStr=req.requestStr.replace("敏感", "mingan")+"--SensitiveFilter";
        fc.doFilter(req, res, fc);
        res.respnseStr+="--SensitiveFilter";


    }

}
