package excel.yaoshuang;

import excel.yaoshuang.vo.HandlerContext;
import excel.yaoshuang.vo.RowInfoVo;

/**
 * @Author dongfucai/1766318593@qq.com
 * @Description //TODO
 * @Date 2019/8/7 下午11:59
 * @Version 1.0
 **/


public interface Handler  {

    void handleData(HandlerContext<RowInfoVo> staffBatchVOHandlerContext);
}
