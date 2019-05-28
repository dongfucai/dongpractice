package time.DateUtil;

import org.apache.commons.lang.math.NumberUtils;
import org.apache.commons.lang3.time.DateUtils;

import java.util.Calendar;
import java.util.Date;

/**
 * @Package Name : ${PACKAG_NAME}
 * @Author : dongfucai@meituan.com
 * @Creation Date : 2019年01月30日下午3:18
 * @Function : todo
 */
public class test {

    public static void main(String[] args) {

        Long startTime = 1548691200001L;
        if (startTime == null) {
            return;
        }

        Date date = new Date(startTime);
        Date beforeTime = DateUtils.ceiling(DateUtils.addDays(date, -1), Calendar.DATE);
        Date endTime = DateUtils.ceiling(date, Calendar.DATE);

        System.out.println(beforeTime.getTime());
        System.out.println(endTime.getTime());

        String orderId = "23418718854909529420";
       // System.out.println(Long.valueOf(orderId));

        String number1 = "89";
        String number2 = "89.00";

        System.out.println(number1.indexOf('.', 0));
        System.out.println(number2.indexOf('.', 0));


        System.out.println();
        System.out.println(Double.valueOf(number1).intValue());
        System.out.println(Double.valueOf(number2).intValue());


    }

}
