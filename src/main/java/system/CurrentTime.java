package system;

import java.sql.SQLOutput;

import static java.lang.Thread.sleep;

/**
 * @Package Name : ${PACKAG_NAME}
 * @Author : dongfucai@meituan.com
 * @Creation Date : 2018年05月28日下午3:06
 * @Function : todo
 */
public class CurrentTime {

    //  currentTimeMillis 作用是返回当前 计算机的时间，时间的表达式为当前计算机时间 和 GMT时间(格林威治时间)1970年1月1号0时0分0秒所差的毫秒数。

    public static void main(String[] args) {

        long currentTime= System.currentTimeMillis();  // 得到的是毫秒



        try {
            sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long end = System.currentTimeMillis();
        System.out.println(end-currentTime);


        String osName =System.getProperty("os.name");
        String user = System.getProperty("user.name");

        System.out.println(osName);
        System.out.println(user);
    }

}
