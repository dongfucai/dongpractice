package delayque.quartz;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @Author dongfucai/1766318593@qq.com
 * @Description //TODO
 * @Date 2020/5/17 下午5:38
 * @Version 1.0
 **/
@Component
public class QuartzDemo {


    //每隔五秒
    @Scheduled(cron = "0/5 * * * * ? ")
    public void process(){
        System.out.println("我是定时任务！");
    }

}
