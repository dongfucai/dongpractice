package random.test.task;

import lombok.Data;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;

/**
 * @Author dongfucai/1766318593@qq.com
 * @Description //TODO
 * @Date 2020/11/12 上午10:44
 * @Version 1.0
 **/
@Data
public class SortTask implements Callable<List> {


    private List data;
    public SortTask(List data) {
        this.data = data;
    }


    @Override
    public List call() throws Exception {
        Collections.sort(data);
        return data;
    }
}
