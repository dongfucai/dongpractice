package excel.yaoshuang.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @Author dongfucai/1766318593@qq.com
 * @Description //TODO
 * @Date 2019/8/7 下午11:34
 * @Version 1.0
 **/
@Data
public class HandlerContext<T extends Serializable> implements Serializable {


    private static final long serialVersionUID = -22L;

    private List<T> handlerList;

    // 记录处理过程中失败的信息
    private StringBuilder handlerStringBuilder = new StringBuilder();

    // 上传的url
    private String filePath;


}
