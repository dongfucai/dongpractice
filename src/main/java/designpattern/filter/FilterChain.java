package designpattern.filter;

import java.util.ArrayList;
import java.util.List;

/**
 * @Package Name : ${PACKAG_NAME}
 * @Author : 1766318593@qq.com
 * @Creation Date : 2018年07月14日下午5:41
 * @Function : todo
 */

// 过滤链  中把过滤器装载进去
public class FilterChain implements Filter{

    private List<Filter> list = new ArrayList<Filter>();

    public FilterChain addfilter(Filter filter){
        list.add(filter);
        return this;
    }

    int index=0;

    @Override
    public void doFilter(Request req,Response res,FilterChain fc){
        if (index == list.size()){
            return ;
        }

        Filter f=list.get(index);

        index++;
        f.doFilter(req,res,fc);

    }


}
