package reactor;

import org.springframework.boot.autoconfigure.web.reactive.WebFluxAutoConfiguration;
import org.springframework.http.converter.json.GsonBuilderUtils;
import reactor.core.publisher.Flux;

/**
 * @Author dongfucai/1766318593@qq.com
 * @Description //TODO
 * @Date 2023/5/8 下午10:00
 * @Version 1.0
 **/

public class ReactorTest {

    public static void main(String[] args) {
        Flux.just(1,2,3);

        Flux.just(1,2,3).subscribe(
                x -> System.out.println(x)

        );


        // map 转换器操作符
        Flux.just(1,2,3,4).map(x -> x*x).subscribe(x -> System.out.println(x));

        // reduce count 统计操作符

        //filter/distinct/take 筛选、操作符
        Flux.just(1,2,3,4).map(x -> x*x).filter(x -> x>4).subscribe(x -> System.out.println(x));



    }


}
