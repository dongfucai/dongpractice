package java8.problem;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @Package Name : ${PACKAG_NAME}
 * @Author : 1766318593@qq.com
 * @Creation Date : 2018年11月17日下午4:42
 * @Function : todo
 */

/**
 * 答案
 * https://my.oschina.net/7001/blog/1475500
 */
public class ParallelStreamTest {
    private static final int COUNT = 1000;
    public static void main(String[] args) {
        List<RiderDto> orilist=new ArrayList<RiderDto>();
        for(int i=0;i<COUNT;i++){
            orilist.add(init());
        }
        //final List<RiderDto> copeList=new ArrayList<RiderDto>();????

        /**
         *   CopyOnWriteArrayList是ArrayList 的一个线程安全的变体，其中所有可变操作（add、set等等）都是通过对底层数组进行一次新的复制来实现的。
         */
        final List<RiderDto> copeList=new CopyOnWriteArrayList<RiderDto>();

        orilist.parallelStream().forEach(rider -> {
            RiderDto t = new RiderDto();
            t.setId(rider.getId());
            t.setCityId(rider.getCityId());
            copeList.add(t);
        });
        System.out.println("orilist size:"+orilist.size());
        System.out.println("copeList size:"+copeList.size());
        System.out.println("compare copeList and list,result:"+(copeList.size()==orilist.size()));
    }
    private static RiderDto init() {
        RiderDto t = new RiderDto();
        Random random = new Random();
        t.setId(random.nextInt(2 ^ 20));
        t.setCityId(random.nextInt(1000));
        return t;
    }
    @Data
    static class RiderDto implements Serializable {
        private static final long serialVersionUID = 1;
        //城市Id
        private Integer cityId;
        //骑手Id
        private Integer id;

    }
}