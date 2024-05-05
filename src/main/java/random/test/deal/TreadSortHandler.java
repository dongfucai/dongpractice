package random.test.deal;

import com.google.common.collect.Lists;
import random.test.dto.ReadDataObject;
import random.test.read_file.ReadFileHandler;
import random.test.task.SortTask;
import random.test.util.ThreadUtils;

import java.io.File;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.stream.Collectors;

/**
 * @Author dongfucai/1766318593@qq.com
 * @Description //TODO
 * @Date 2020/11/12 上午10:28
 * @Version 1.0
 **/

public class TreadSortHandler {

    static  ExecutorService executorService = ThreadUtils.createPoolWithFixQueue(16, 16, 1, "TreadSortHandler-%d");
    static  File file = null;

    static  List<List> res = Lists.newArrayList();

    static public List<List> threadHandle() {

        List<Future<List>> lists = Lists.newArrayList();
        List<ReadDataObject> readDataObjects = ReadFileHandler.readGetData(file);

        for (ReadDataObject readDataObject : readDataObjects) {
            Future<List>  listFuture = executorService.submit(new SortTask(readDataObject.getReadData()));
            lists.add(listFuture);
        }
        System.out.println();
        for (Future<List> future : lists) {
             List t = ThreadUtils.getFutureResult(future);
            System.out.println(t.stream().map(String::valueOf).collect(Collectors.joining(", ")));

            res.add(t);
        }
        return res ;

    }


    public static void main(String[] args) {

        TreadSortHandler treadSortHandler = new TreadSortHandler();

        //TreadSortHandler.threadHandle();


        String[] str = new String[]{"a","b","c","d","e"};

        List<Future> list = Lists.newArrayList();
        for (String node : str) {
            Future future = executorService.submit(() -> {

                NodeTest nodeTest = new NodeTest();

                try {
                    nodeTest.tranFlow(node);
                } catch (Exception e) {
                    e.printStackTrace();
                }


            });
            list.add(future);

        }

        for (Future f : list) {
            try {
                f.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }



    }



}
