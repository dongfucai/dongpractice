package delayque.quartz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @Author dongfucai/1766318593@qq.com
 * @Description //TODO
 * @Date 2020/5/17 下午5:37
 * @Version 1.0
 **/

@EnableScheduling
@SpringBootApplication
public class DelayqueueApplication {
    public static void main(String[] args) {
        SpringApplication.run(DelayqueueApplication.class, args);
    }


}
