package date;

import org.apache.commons.lang.time.DateUtils;
import org.apache.poi.ss.usermodel.DateUtil;

import javax.management.InvalidApplicationException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @Author dongfucai/1766318593@qq.com
 * @Description //TODO
 * @Date 2020/11/12 下午3:42
 * @Version 1.0
 **/

public class Test {

    public static void main(String[] args) throws Exception{


        String str = "2020.3.5";

        DateFormat format1 = new SimpleDateFormat("yyyy.M.d");

        DateFormat format2 = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
        Date date = null;
        Date date2 = null;

        // String转Date
        //
       // str = "2007-1-18";
        try {
            date = format1.parse(str);
            //date2 = format2.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        System.out.println(date);
        System.out.println(date2);

        checkDate(str);



        Date date1 = new Date();

        Calendar calendar = Calendar.getInstance();
        System.out.println("2333333     "  + calendar.get(Calendar.YEAR));


        calendar.setTime(date1);
        //calendar.add(Calendar.DAY_OF_MONTH,1);//把日期往后增加一天.整数往后推,负数往前移动
        calendar.add(Calendar.HOUR, 10);
        date2= calendar.getTime(); //这个时间就是日期往后推一天的结果


        System.out.println(date1);
        System.out.println(date2);
        yingyeTime(date1, date2);

    }


    /*
     * 校验年月日
     * */
    public static void checkDate(String date) throws Exception {
        String data[] = date.split("\\.");
        String year = data[0];
        if (Integer.valueOf(year) < 2000 || Integer.valueOf(year) > 2999) {
            throw new InvalidApplicationException("年不正确");
        }
        String month = data[1];
        if (Integer.valueOf(month) > 12 || Integer.valueOf(month) < 1) {
            throw new InvalidApplicationException("月不正确");

        }
        String regx1 = "[1]|[3]|[5]|[7]|[8]|[10]|[12]";
        String day = data[2];
        System.out.println(day);
        System.out.println(month);
        String regx2 = "([4])|([6])|([9])|([11])";
        int flag = checkYear(year);
        if (flag == 0 && Integer.valueOf(month) == 2 && Integer.valueOf(day) > 29) {
            throw new Exception("闰年月天不正确");
        }
        if (flag == 1 && Integer.valueOf(month) == 2 && Integer.valueOf(day) > 28) {
            throw new Exception("平年月天不正确");
        }
        if (isMatch(regx2, month) && Integer.valueOf(day) > 30) {
            throw new Exception("天不正确");
        }
        if (isMatch(regx1, month) && Integer.valueOf(day) > 31) {
            throw new Exception("天不正确");
        }


        if (isMatch(month,"[0-9]")&&isMatch(day,"[0-9]")){
            System.out.println(date);

            System.out.println(111111111);
            SimpleDateFormat s2 = new SimpleDateFormat("yyyy.M.d");
            Date date1 = s2.parse(date);
            System.out.println(date1);


            SimpleDateFormat s1 = new SimpleDateFormat("YYYY年M月d日");
            String date2 = s1.format(date1);


            System.out.println(date2);
        }else if (isMatch(month,"[0-9][0-9]")&&isMatch(day,"[0-9][0-9]")){
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日");
            SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyyy.MM.dd");
            Date date1 = simpleDateFormat1.parse(date);
            String data2 = simpleDateFormat.format(date1);
            System.out.println(data2);
        }else if (isMatch(month,"[0-9][0-9]")&&isMatch(day,"[0-9]")){
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY年MM月d日");
            SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("YYYY.MM.d");
            Date date1 = simpleDateFormat1.parse(date);
            String data2 = simpleDateFormat.format(date1);
            System.out.println(data2);
        }else {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY年M月dd日");
            SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("YYYY.M.dd");
            Date date3 = simpleDateFormat1.parse(date);
            String data2 = simpleDateFormat.format(date3);
            System.out.println(data2);
        }
    }

    /*
     * 正则表达式的校验
     * */
    public static boolean isMatch(String s,String p){
        if (s.matches(p)){
            return true;

        }else {
            return false;
        }

    }

    /*
     * 校验是否是闰年还是平年
     *
     * */
    public static int  checkYear(String year){
        //0是闰年
        //1是平年
        int flag =0;
        int year1 = Integer.valueOf(year);
        if ((year1%400==0)||(year1%4==0&&year1%100!=0)){
            flag = 0;
        }else {
            flag =1;
        }
        return flag;

    }


    /**
     *
     */
    public static void yingyeTime(Date startStr, Date endStr) {

        String format = "HH:mm";

        SimpleDateFormat sfdTime = new SimpleDateFormat(format);


        String  openTime = sfdTime.format(startStr);
        String closeTime = sfdTime.format(endStr);
        String nowTime = sfdTime.format(new Date());

        System.out.println("openTimeLong : " + openTime);
        System.out.println("closeTimeLong: " + closeTime);
        System.out.println("nowTimeLong: " + nowTime);



        try {
            long openTimeLong = sfdTime.parse(openTime).getTime();
            long closeTimeLong = sfdTime.parse(closeTime).getTime();
            long nowTimeLong = sfdTime.parse(nowTime).getTime();



            System.out.println("openTimeLong : " + openTimeLong);
            System.out.println("closeTimeLong: " + closeTimeLong);
            System.out.println("nowTimeLong: " + nowTimeLong);

            if (openTimeLong > closeTimeLong) {
                closeTimeLong += sfdTime.parse("24:00").getTime();
                System.out.println("             closeTimeLong: " + closeTimeLong);

            }

            if (openTimeLong < nowTimeLong && nowTimeLong < closeTimeLong) {
                System.out.println("正在营业");
            } else {
                System.out.println("mei 有 营业");
            }


        } catch (ParseException e) {
            e.printStackTrace();
        }





    }



}
