package com.callabledemo;



import com.google.common.collect.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;

/**
 * @Package Name : ${PACKAG_NAME}
 * @Author : 1766318593@qq.com
 * @Creation Date : 2018年08月14日下午2:16
 * @Function : todo
 */


class TaskWithResult implements Callable<String> {
    private int id;
    public TaskWithResult(int id){
        this.id = id;
    }

    @Override
    public String call(){
        return "result of TaskWithResult " + id;
    }



}

public class CallableDemo {

    public static void main(String[] args) {


        ExecutorService executorService = Executors.newCachedThreadPool();
        List<Future<String>> result = Lists.newArrayList();


        for (int i = 0;i < 10; i++){
            result.add(executorService.submit(new TaskWithResult(i)));
        }


        for (Future<String> fs : result){

            try {
                System.out.println(fs.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }finally {
                executorService.shutdown();
            }
        }


    }


}
