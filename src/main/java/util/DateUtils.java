//package util;
//
//import org.joda.time.DateTime;
//import org.joda.time.format.DateTimeFormat;
//
//import java.text.ParseException;
//import java.time.format.DateTimeFormatter;
//import java.util.Calendar;
//import java.util.Date;
//
///**
// * @Package Name : ${PACKAG_NAME}
// * @Author : 1766318593@qq.com
// * @Creation Date : 2018年09月07日下午2:41
// * @Function : todo
// */
//public class DateUtils {
//    public static final String FORMAT_NO_HHMMSS = "yyyy-MM-dd";
//    public static final DateTimeFormatter format = DateTimeFormat.forPattern(FORMAT_NO_HHMMSS);
//
//
//    public static int getCurrentYearAndMonthAndDay(){
//        Calendar cale = Calendar.getInstance();
//        int year = cale.get(Calendar.YEAR);
//        int day = cale.get(Calendar.DAY_OF_MONTH);
//        int res = year*10000 + (cale.get(Calendar.MONTH) + 1)*100+day;
//        return res;
//    }
//
//    public static long getDayMinusN(int n){
//        Calendar cale = Calendar.getInstance();
//        cale.add(Calendar.DAY_OF_MONTH, n);
//        cale.set(Calendar.HOUR_OF_DAY, 0);
//        cale.set(Calendar.MINUTE, 0);
//        cale.set(Calendar.SECOND, 0);
//        cale.set(Calendar.MILLISECOND, 0);
//        return cale.getTimeInMillis();
//    }
//
//    public static boolean isSameDay(Date original, Date target) {
//        if (original == null || target == null) {
//            throw new IllegalArgumentException("日期不能为null");
//        }
//
//        Calendar cal = Calendar.getInstance();
//        cal.setTime(original);
//
//        Calendar cal1 = Calendar.getInstance();
//        cal1.setTime(target);
//        return isSameDay(cal, cal1);
//    }
//
//    public static boolean isStartAcceptTimeToday(Date original) {
//        if (original == null) {
//            throw new IllegalArgumentException("日期不能为null");
//        }
//
//        Calendar cal = Calendar.getInstance();
//        cal.setTime(original);
//
//        Calendar cal1 = Calendar.getInstance();
//        cal1.setTime(new Date());
//        return isSameDay(cal, cal1);
//    }
//
//    public static boolean isSameDay(Calendar original, Calendar target) {
//        if (original == null || target == null) {
//            throw new IllegalArgumentException("日期不能为null");
//        }
//        return (original.get(Calendar.ERA) == target.get(Calendar.ERA) &&
//                original.get(Calendar.YEAR) == target.get(Calendar.YEAR) &&
//                original.get(Calendar.DAY_OF_YEAR) == target.get(Calendar.DAY_OF_YEAR));
//    }
//
//    public static Date getDayOfLastTime(Date target){
//        if (target == null) {
//            throw new IllegalArgumentException("日期不能为null");
//        }
//
//        Calendar cal = Calendar.getInstance();
//        cal.setTime(target);
//        cal.set(Calendar.HOUR_OF_DAY, 23);
//        cal.set(Calendar.MINUTE, 59);
//        cal.set(Calendar.SECOND, 59);
//
//        return cal.getTime();
//    }
//
//    public static Date getDayOfOriginal(Date target){
//        if (target == null) {
//            throw new IllegalArgumentException("日期不能为null");
//        }
//
//        Calendar cal = Calendar.getInstance();
//        cal.setTime(target);
//        cal.set(Calendar.HOUR_OF_DAY, 0);
//        cal.set(Calendar.MINUTE, 0);
//        cal.set(Calendar.SECOND, 0);
//        cal.set(Calendar.MILLISECOND, 0);
//
//        return cal.getTime();
//    }
//
//    public static String transDate2Str(Date source){
//        return new DateTime(source).toString(format);
//    }
//
//
//    public static Date transStr2Date(String source) throws ParseException {
//        return DateTime.parse(source, format).toDate();
//    }
//
//    /**
//     * @Title: parseDateBetween
//     * @Description: 根据开始时间和结束时间，解析开始时间和结束时间之间的日期，得到所有的日期字符串数组
//     * @param  start   参数
//     * @return ${return_type}    返回类型
//     * @throws
//     */
//    public static String[] parseDateBetween(Date start, Date end){
//        int between = getTwoDay(start, end);
//        String[] dayArray = new String[between + 1];
//
//        Calendar cal = Calendar.getInstance();
//        cal.setTime(start);
//        for (int i = 0; i < dayArray.length; i++) {
//            cal.add(Calendar.DAY_OF_YEAR, i);
//            dayArray[i] = transDate2Str(cal.getTime());
//            cal.add(Calendar.DAY_OF_YEAR, -i);
//        }
//
//        return dayArray;
//    }
//
//    public static int getTwoDay(Date start, Date end) {
//        if(start == null || end == null){
//            return 0;
//        }
//        long day = 0l;
//        try {
//            day = (end.getTime() - start.getTime()) / (24 * 60 * 60 * 1000);
//        } catch (Exception e) {
//            return 0;
//        }
//        return (int) day;
//    }
//
//    public static Date addDays(Date source, int days){
//        Calendar cal = Calendar.getInstance();
//        cal.setTime(source);
//        cal.add(Calendar.DAY_OF_YEAR, days);
//        return cal.getTime();
//    }
//
//    /**
//     * 获取当天0:0:0.0的时间戳（单位毫秒）
//     * @param timestamp
//     * @return
//     */
//    public static Long getStartOfDayTimestamp(Long timestamp){
//        if (timestamp == null){
//            return 0L;
//        }
//        return new DateTime(timestamp).withTime(0,0,0,0).getMillis();
//    }
//
//    /**
//     * 获取当天23:59:59:999的时间戳（单位毫秒）
//     * @param timestamp
//     * @return
//     */
//    public static Long getEndOfDayTimestamp(Long timestamp){
//        if (timestamp == null){
//            return 0L;
//        }
//        return new DateTime(timestamp).withTime(23,59,59,999).getMillis();
//    }
//
//    public static void main(String[] args) {
////        String defaultDatePattern = "yyyy-MM-dd ";
////
////        String start = "1497580310";
////        String end = "1499308310";
////        Long startLong = Long.parseLong(start) * 1000;
////        Long endLong = Long.parseLong(end) * 1000;
////        Date startDate = new Date(startLong);
////        Date endDate = new Date(endLong);
////
////        //计算日期间隔
////        String[] days = com.dianping.csc.common.util.DateUtils.parseDateBetween(startDate, endDate);
////        Date now = new Date();
////        Date beforMonth = org.apache.commons.lang3.time.DateUtils.addMonths(now, -1);
////        System.out.println(transDate2Str(now));
////        System.out.println(transDate2Str(beforMonth));
////
////        System.out.println("*********************");
////        System.out.println(now.getTime());
////        System.out.println(System.currentTimeMillis());
////        System.out.println(getCurrentYearAndMonthAndDay());
//        System.out.println(getDayMinusN(-29));
//
//
//    }
//
//}
