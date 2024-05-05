package random.test.deal;

/**
 * @Author dongfucai/1766318593@qq.com
 * @Description //TODO
 * @Date 2021/8/17 下午10:13
 * @Version 1.0
 **/

public class NodeTest {


    public void tranFlow(String node) throws Exception{
        //Thread.currentThread().setName("dongfucai" + node);

        System.out.println(" start longgggggg    gggg : " + node);


        System.out.println("thread name " + Thread.currentThread().getName());
        Thread.sleep(200);




        System.out.println(" end longgggggg    gggg : " + node);




    }
}
