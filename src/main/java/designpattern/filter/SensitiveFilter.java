package designpattern.filter;

/**
 * @Package Name : ${PACKAG_NAME}
 * @Author : dongfucai@meituan.com
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
