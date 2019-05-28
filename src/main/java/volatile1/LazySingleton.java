package volatile1;

import java.util.Calendar;
import java.util.Date;

/**
 * @Package Name : ${PACKAG_NAME}
 * @Author : 1766318593@qq.com
 * @Creation Date : 2018年05月11日下午6:26
 * @Function : todo
 */
public class LazySingleton {

    private static  volatile LazySingleton instance=null;

    public static LazySingleton getInstance(){
        if(instance==null){
            instance=new LazySingleton();
        }
        return instance;
    }

    public static void main(String[] args) {

        //System.out.println( LazySingleton.getInstance());
       // System.out.println(new Date(34535534));
        Calendar curr = Calendar.getInstance();
        curr.set(Calendar.DAY_OF_MONTH,curr.get(Calendar.DAY_OF_MONTH)+7);
        Date date=curr.getTime();

        //推迟一月代码：

        Calendar curr1 = Calendar.getInstance();
        curr1.set(Calendar.MONTH,curr1.get(Calendar.MONTH)+1);
        Date date1=curr1.getTime();

        //推迟一年代码：

        Calendar curr2 = Calendar.getInstance();
        curr2.set(Calendar.YEAR,curr2.get(Calendar.YEAR)+1);
        Date date2=curr2.getTime();

        System.out.println(curr.getTime().getTime());
        System.out.println(curr1.getTime().getTime());
        System.out.println(curr2.getTime().getTime());

    }

}
