package git;

import lombok.Data;

/**
 * @Author dongfucai/1766318593@qq.com
 * @Description //TODO
 * @Date 2019/11/18 下午1:26
 * @Version 1.0
 **/
@Data
public class RetObj {


    public RetObj(String status, Object object) {
        this.status = status;
        this.result = object;
    }


    private String status;

    private Object result;


}
