package designpattern.filter;

/**
 * @Package Name : ${PACKAG_NAME}
 * @Author : dongfucai@meituan.com
 * @Creation Date : 2018年07月14日下午5:39
 * @Function : todo
 */
public class HTMLFilter implements Filter {


    @Override
    public void doFilter(Request req,Response res,FilterChain fc){
        req.requestStr =  req.requestStr.replace("<","{");
        req.requestStr =  req.requestStr.replace(">","}")+"--HTMLFilter";

        fc.doFilter(req,res,fc);

        //在这里它会调用过滤链中的下一个filter
        //等整个过滤链处理完了之后也就是fc.doFilter(req, res, fc);这段
        //处理完了之后就会执行下面的方法了res.responseStr+="--HTMLFilter";
        //然后依次的过滤器都执行这列的这行代码，也就会变成了倒序执行

        res.respnseStr+="--HTMLFilter";



    }

}
