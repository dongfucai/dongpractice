package logic;

import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @Package Name : ${PACKAG_NAME}
 * @Author : dongfucai@meituan.com
 * @Creation Date : 2018年06月11日上午10:58
 * @Function : todo
 */
public class LogicTest {

    public static void main(String[] args) {

        int queryFailCount = 0;
        do {

            if (true) {
                queryFailCount++;
                if (queryFailCount < 3) {
                    System.out.println("queryFailCount = "+queryFailCount );
                    continue;
                }
                System.out.println("break;queryFailCount="+queryFailCount);
                break;
            }
            queryFailCount = 0;

        }while (queryFailCount>=0);

        int i = 0;
        do
        {
            System.out.println("1111111");
            if(i < 10)
                continue;
        }while(++i < 10);

    }

}
