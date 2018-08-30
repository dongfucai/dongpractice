package ListMap;

/**
 * @Package Name : ${PACKAG_NAME}
 * @Author : dongfucai@meituan.com
 * @Creation Date : 2018年07月17日下午8:00
 * @Function : todo
 */

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Data
class FakeplateOrderFeedbackResponse implements Serializable {

     private String orderId;
     private String channel;
     private Long createTime;


 }

 @Data
class FakeplateVerifyTaskResponse implements Serializable {

    private Integer status;
    private String result;
    private String compensate;
    private List<FakeplateOrderFeedbackResponse> FakeplateOrderFeedbackResponseList;
}

public class Test {

    private static final Logger logger = LoggerFactory.getLogger(Test.class);

    public static void main(String[] args) {

        List<Map> data = new ArrayList<Map>();

        init(data);

        System.out.println("排序前:");
        System.out.println(data);
        sort(data);
        System.out.println("排序后:");
        System.out.println(data);

        FakeplateVerifyTaskResponse fake = new FakeplateVerifyTaskResponse();

        fake.setStatus(11);
        fake.setResult("23334");

        logger.info("sdfsf=={}",fake);
        System.out.println(fake);


    }

    private static void sort(List<Map> data) {

        Collections.sort(data, new Comparator<Map>() {

            public int compare(Map o1, Map o2) {

                Long a = (Long) o1.get("PRECOUNTOUT");
                Long b = (Long) o2.get("PRECOUNTOUT");

                // 升序
               // return a.compareTo(b);

                // 降序
                 return b.compareTo(a);
            }
        });
    }

    private static void init(List<Map> data) {

        Map  map = new HashMap();
        map.put("COUNTTICKET", "a");
        map.put("PRECOUNTOUT", 345L);
        data.add(map);
//
        map = new HashMap<String, String>();
        map.put("COUNTTICKET", "b");
        map.put("PRECOUNTOUT", 34L);
        data.add(map);
//
        map = new HashMap<String, String>();
        map.put("COUNTTICKET", "c");
        map.put("PRECOUNTOUT", 33333333L);
        data.add(map);
//
//        map = new HashMap<String, String>();
//        map.put("COUNTTICKET", "d");
//        map.put("PRECOUNTOUT", "a");
//        data.add(map);
    }
}
