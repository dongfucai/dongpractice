package random.test.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @Author dongfucai/1766318593@qq.com
 * @Description //TODO
 * @Date 2020/11/12 上午10:36
 * @Version 1.0
 **/

@Data
public class ReadDataObject implements Serializable {

    /**
     * 读取的数据对象
     */
    List  readData;

}
