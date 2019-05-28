package util;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Package Name : ${PACKAG_NAME}
 * @Author : 1766318593@qq.com
 * @Creation Date : 2018年09月07日下午2:42
 * @Function : todo
 */
public class StringUtils {

    /**
     * 首字母小写
     * @param str
     * @return
     */
    public static String toFirstLow(String str){
        return str.substring(0,1).toLowerCase()+str.substring(1);
    }

    /**
     * 首字母大写
     * @param str
     * @return
     */
    public static String toFirstUp(String str){
        return str.substring(0,1).toUpperCase()+str.substring(1);
    }

    /**
     * 得到当前日期，包含时分秒
     * @return
     */
    public static String getNowDateWithMin() {
        Calendar calendar = Calendar.getInstance();
        String NowYear = Integer.toString(calendar.get(Calendar.YEAR));
        String NowMonth = Integer.toString((calendar.get(Calendar.MONTH) + 1));
        String NowDay = Integer.toString(calendar.get(Calendar.DAY_OF_MONTH));
        String NowHour = Integer.toString(calendar.get(Calendar.HOUR_OF_DAY));
        String NowMinute = Integer.toString(calendar.get(Calendar.MINUTE));
        String NowSecond = Integer.toString(calendar.get(Calendar.SECOND));
        String NowDate = NowYear + "-"
                + (NowMonth.length() == 1 ? "0" + NowMonth : NowMonth) + "-"
                + (NowDay.length() == 1 ? "0" + NowDay : NowDay) + " "
                + (NowHour.length() == 1 ? "0" + NowHour : NowHour) + ":"
                + (NowMinute.length() == 1 ? "0" + NowMinute : NowMinute) + ":"
                + (NowSecond.length() == 1 ? "0" + NowSecond : NowSecond);
        return NowDate;
    }

    /**
     * 得到当前日期，包含时分秒 -1分钟
     * @return
     */
    public static String getOneSSTime() {
        Date currentDate = new Date();
        currentDate.setMinutes(currentDate.getMinutes() - 5);
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(currentDate);
    }

    /**
     * 得到当前日期，包含时分秒
     * @return
     */
    public static String getNowTime() {
        Calendar calendar = Calendar.getInstance();
        String NowHour = Integer.toString(calendar.get(Calendar.HOUR_OF_DAY));
        String NowMinute = Integer.toString(calendar.get(Calendar.MINUTE));
        String NowSecond = Integer.toString(calendar.get(Calendar.SECOND));
        String NowDate = ""
                + (NowHour.length() == 1 ? "0" + NowHour : NowHour) + ":"
                + (NowMinute.length() == 1 ? "0" + NowMinute : NowMinute) + ":"
                + (NowSecond.length() == 1 ? "0" + NowSecond : NowSecond);
        return NowDate;
    }



    public static String getRandomNum() {
        Calendar calendar = Calendar.getInstance();
        String NowYear = Integer.toString(calendar.get(Calendar.YEAR));
        String NowMonth = Integer.toString((calendar.get(Calendar.MONTH) + 1));
        String NowDay = Integer.toString(calendar.get(Calendar.DAY_OF_MONTH));
        String NowHour = Integer.toString(calendar.get(Calendar.HOUR_OF_DAY));
        String NowMinute = Integer.toString(calendar.get(Calendar.MINUTE));
        String NowSecond = Integer.toString(calendar.get(Calendar.SECOND));
        String NowDate = NowYear
                + (NowMonth.length() == 1 ? "0" + NowMonth : NowMonth)
                + (NowDay.length() == 1 ? "0" + NowDay : NowDay)
                + (NowHour.length() == 1 ? "0" + NowHour : NowHour)
                + (NowMinute.length() == 1 ? "0" + NowMinute : NowMinute)
                + (NowSecond.length() == 1 ? "0" + NowSecond : NowSecond);
        Random ran = new Random();
        NowDate = NowDate+""+ran.nextInt(100);
        return NowDate;
    }
    /**
     * 得到当前日期的字符串，不包含时：分
     * yyyy年mm月dd日
     * @return
     */
    public static String getCurrentDate() {
        Calendar calendar = Calendar.getInstance();
        String NowYear = Integer.toString(calendar.get(Calendar.YEAR));
        String NowMonth = Integer.toString((calendar.get(Calendar.MONTH) + 1));
        String NowDay = Integer.toString(calendar.get(Calendar.DAY_OF_MONTH));
        String NowDate = NowYear + "年"
                + (NowMonth.length() == 1 ? "0" + NowMonth : NowMonth) + "月"
                + (NowDay.length() == 1 ? "0" + NowDay : NowDay)+"日";
        return NowDate;
    }
    /**
     * 得到当前日期的字符串，不包含时：分
     *
     * @return
     */
    public static String getNowDateWithOutMin() {
        Calendar calendar = Calendar.getInstance();
        String NowYear = Integer.toString(calendar.get(Calendar.YEAR));
        String NowMonth = Integer.toString((calendar.get(Calendar.MONTH) + 1));
        String NowDay = Integer.toString(calendar.get(Calendar.DAY_OF_MONTH));
        String NowDate = NowYear + "-"
                + (NowMonth.length() == 1 ? "0" + NowMonth : NowMonth) + "-"
                + (NowDay.length() == 1 ? "0" + NowDay : NowDay);
        return NowDate;
    }
    /**
     * 得到当前日期yyyy-MM，不包含时：分
     *
     * @return
     */
    public static String getCurrentMonth() {
        Calendar calendar = Calendar.getInstance();
        String NowYear = Integer.toString(calendar.get(Calendar.YEAR));
        String NowMonth = Integer.toString((calendar.get(Calendar.MONTH) + 1));
        String NowDate = NowYear + "-"
                + (NowMonth.length() == 1 ? "0" + NowMonth : NowMonth);
        return NowDate;
    }


    public static String returnStr(String str){
        if(str != null && !"null".equals(str) && !"NULL".equals(str)){
            return str;
        }else{
            return "";
        }
    }

    public static String returnOrderNum(String orderNum){
        if(orderNum.length() == 1){
            return "00"+orderNum;
        }else if(orderNum.length() == 2){
            return "0"+orderNum;
        }else{
            return orderNum;
        }
    }

    public static String returnCodeNum(String codeNum){
        if(codeNum == null || "".equals(codeNum)){
            codeNum = "001";
        }
        try{
            int num = Integer.valueOf(codeNum) + 1;
            return returnOrderNum(String.valueOf(num));
        }catch(Exception e){
            return codeNum;
        }
    }

    public static String htmlspecialchars(String str) {
        str = str.replaceAll("&", "&amp;");
        str = str.replaceAll("<", "&lt;");
        str = str.replaceAll(">", "&gt;");
        str = str.replaceAll("\"", "&quot;");
        return str;
    }

    /**
     * 将日期格式去掉时分秒后返回
     * @param str
     * @return
     */
    public static String returnDate(String str){
        if (str.length() > 10) {
            return str.substring(0, 10);
        }else{
            return str;
        }
    }
    /**
     * 将字段所见为15返回
     * @param str
     * @return
     */
    public static String returnLimitStr(String str){
        if (str.length() > 25) {
            return str.substring(0, 25)+"...";
        }else{
            return str;
        }
    }

    /**
     * 将字段所见为length返回
     * @param str
     * @return
     */
    public static String returnLimitStr(String str,int length){
        if (str.length() > length) {
            return str.substring(0, length)+"...";
        }else{
            return str;
        }
    }


    public static String returnNextMonth(String date) throws Exception{
        Date current_date = new SimpleDateFormat("yyyy-MM").parse(date);
        current_date.setMonth(current_date.getMonth()+1);
        return new SimpleDateFormat("yyyy-MM").format(current_date);
    }

    public static String returnRandomNo(){
        Calendar calendar = Calendar.getInstance();
        String NowYear = Integer.toString(calendar.get(Calendar.YEAR));
        String NowMonth = Integer.toString((calendar.get(Calendar.MONTH) + 1));
        String NowDay = Integer.toString(calendar.get(Calendar.DAY_OF_MONTH));
        String r_number = NowYear + (NowMonth.length() == 1 ? "0" + NowMonth : NowMonth) + (NowDay.length() == 1 ? "0" + NowDay : NowDay);
        r_number = r_number+(System.currentTimeMillis() >>> 8);
        return r_number;

    }
    /**
     *
     * 功能描述：返回系统流水号
     * 创建于：2013-5-27 上午01:00:05
     * 作者： Gemini
     * @return
     * 返回：String
     */
    public static String returnSysBH(){
        Calendar calendar = Calendar.getInstance();
        String NowYear = Integer.toString(calendar.get(Calendar.YEAR));
        String NowMonth = Integer.toString((calendar.get(Calendar.MONTH) + 1));
        String NowDay = Integer.toString(calendar.get(Calendar.DAY_OF_MONTH));
        return NowYear+NowMonth+NowDay+String.valueOf((System.currentTimeMillis()));
    }
    /**
     * 处理异常字符串
     *
     * @param str
     * @param defaultStr
     * @return
     */
    public static String returnStr(String str, String defaultStr) {
        if (str != null && !"null".equals(str) && !"NULL".equals(str)
                && !"".equals(str.trim()) && !" ".equals(str.trim())) {
            return str;
        } else {
            if (defaultStr != null) {
                return defaultStr;
            } else {
                return "";
            }
        }
    }

    /**
     *
     * 返回数字，处理异常
     * @param str
     * @param str
     * @return
     */
    public static Integer returnInteger(String str) {
        try{
            return Integer.valueOf(str);
        }catch(Exception e){
            return 0;
        }
    }


    public static String returnStrByLine(String str){
        if(str == null || "".equals(str)){
            return str;
        }else{
            if(str.length() <= 8){
                return str;
            }else{
                String str1 = str.substring(0,8);
                String str2 = str.substring(8, str.length());
                return str1+"\r\n"+str2;
            }
        }
    }
    public static void main(String[] args) throws Exception{
        System.out.println(returnStrByLine("其他委托服务采购项目11231"));
    }



    /**
     * 返回当前年份
     *
     * @param
     * @return
     */
    public static String returnCurrentYear() {
        return new SimpleDateFormat("yyyy").format(new Date());
    }



    /**
     *
     * 功能描述：传入标准 YYYY-MM-DD 格式日期，返回年
     * 创建于：2013-5-24 下午04:42:53
     * 作者： Gemini
     * @param str
     * @return
     * 返回：String
     */
    public static String getYearByStr(String str){
        if(str == null || "".equals(str)){
            str = getNowDateWithOutMin();
        }
        return str.substring(0,4);
    }

    /**
     *
     * 功能描述：传入标准 YYYY-MM-DD 格式日期，返回月
     * 创建于：2013-5-24 下午04:42:53
     * 作者： Gemini
     * @param str
     * @return
     * 返回：String
     */
    public static String getMonthByStr(String str){
        if(str == null || "".equals(str)){
            str = getNowDateWithOutMin();
        }
        return str.substring(5,7);
    }

    /**
     *
     * 功能描述：传入标准 YYYY-MM-DD 格式日期，返回日
     * 创建于：2013-5-24 下午04:42:53
     * 作者： Gemini
     * @param str
     * @return
     * 返回：String
     */
    public static String getDayByStr(String str){
        if(str == null || "".equals(str)){
            str = getNowDateWithOutMin();
        }
        return str.substring(8,10);
    }



    /**
     * 得到当前日期的字符串，yyyy年MM月
     *
     * @return
     */
    public static String getNowDateWithNY() {
        Calendar calendar = Calendar.getInstance();
        String NowYear = Integer.toString(calendar.get(Calendar.YEAR));
        String NowMonth = Integer.toString((calendar.get(Calendar.MONTH) + 1));
        String NowDate = NowYear + "年"
                + (NowMonth.length() == 1 ? "0" + NowMonth : NowMonth) + "月";
        return NowDate;
    }

    /**
     * 截取字符串 返回标准日期格式 yyyy年-MM月-dd日
     *
     * @param str
     * @return
     */
    public static String returnDate_1(String str) {
        if (str != null && str.length() > 11) {
            return str.substring(0, 10);
        } else {
            return new SimpleDateFormat("yyyy年MM月dd日")
                    .format(new Date());
        }
    }

    /**
     *
     * 功能描述：提出所有的html标签
     * 创建于：2013-1-7 上午10:20:50
     * 作者： Gemini
     * @param content
     * @return
     * 返回：String
     */
    public static String removeTagFromText(String content) {
        Pattern p = null;
        Matcher m = null;
        String value = null;
        // 去掉<>标签
        p = Pattern.compile("(<[^>]*>)");
        m = p.matcher(content);
        String temp = content;
        while (m.find()) {
            value = m.group(0);
            temp = temp.replace(value, "");
        }

        // 去掉换行或回车符号
        p = Pattern.compile("(/r+|/n+)");
        m = p.matcher(temp);
        while (m.find()) {
            value = m.group(0);
            temp = temp.replace(value, " ");
            // System.out.println("....." + value);
        }
        temp=temp.replace("&nbsp;", "  ");
        temp=temp.replace("\n", "");
        temp=temp.replace("\r", "");
        temp=temp.replace("\t", "");
        temp=temp.replace(" ", "");
        temp=temp.replace("	", "");


        return temp;
    }
    public static String replace(String string, String oldString,
                                 String newString) {
        return innerReplace(string, oldString, newString, true);
    }
    public static boolean isEmpty(String str){
        if(str == null || "".equals(str)){
            return true;
        }else{
            return false;
        }
    }
    private static String innerReplace(String string, String oldString,
                                       String newString, boolean isAll) {
        if (string == null)
            return "";
        int index = string.indexOf(oldString);
        if (index == -1)
            return string;
        int start = 0, len = oldString.length();
        if (len == 0)
            return string;
        StringBuilder buffer = new StringBuilder(string.length() + len);
        do {
            buffer.append(string.substring(start, index));
            buffer.append(newString);
            start = index + len;
            if (!isAll)
                break;
            index = string.indexOf(oldString, start);
        } while (index != -1);
        buffer.append(string.substring(start));
        return buffer.toString();
    }
    public static String removeEnter(String temp){
        if(temp != null && !"".equals(temp)){
            Pattern p = null;
            Matcher m = null;
            String value = null;
            p = Pattern.compile("(/r+|/n+)");
            m = p.matcher(temp);
            while (m.find()) {
                value = m.group(0);
                temp = temp.replace(value, " ");
            }
            temp=temp.replace("&nbsp;", "");
            temp=temp.replace("\n", "");
            temp=temp.replace("\r", "");
            temp=temp.replace("\t", "");
            temp=temp.replace(" ", "");
            temp=temp.replace("	", "");
            return temp;
        }else{
            return "";
        }
    }
    /**
     *
     * 功能描述：返回sub字符串
     * 创建于：2013-1-7 上午10:44:04
     * 作者： Gemini
     * @param str
     * @return
     * 返回：String
     */
    public static String returnSubStr(String str){
        if(str != null && str.length() >= 100){
            return str.substring(0,95)+"...";
        }else{
            return str+"...";
        }
    }

    /**
     * 功能描述：返回两个日期相减的天数  建议date1 大于 date2 这样计算的值为正数
     * @return
     * 返回：int
     */
    public static int daysOfTwo(long date1, long date2) {
        if(date2 > date1){
            date2 = date2 + date1;
            date1 = date2 - date1;
            date2 = date2 - date1;
        }
        Calendar calendar1 = Calendar.getInstance(); // 获得一个日历
        calendar1.setTimeInMillis(date1); // 用给定的 long 值设置此 Calendar 的当前时间值。
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTimeInMillis(date2);
        // 先判断是否同年
        int y1 = calendar1.get(Calendar.YEAR);
        int y2 = calendar2.get(Calendar.YEAR);
        int d1 = calendar1.get(Calendar.DAY_OF_YEAR);
        int d2 = calendar2.get(Calendar.DAY_OF_YEAR);
        int maxDays = 0;
        int day = 0;
        if(y1 - y2 > 0){
            day = numerical(maxDays, d1, d2, y1, y2, calendar2);
        }else{
            day = d1 - d2;
        }
        return day;
    }

    /**
     * 日期间隔计算
     * 计算公式(示例):
     *      20121230 - 20071001
     *      取出20121230这一年过了多少天 d1 = 365     取出20071001这一年过了多少天 d2 = 274
     *      如果2007年这一年有366天就要让间隔的天数+1，因为2月份有29日。
     * @param maxDays   用于记录一年中有365天还是366天
     * @param d1    表示在这年中过了多少天
     * @param d2    表示在这年中过了多少天
     * @param y1    当前为2010年
     * @param y2    当前为2012年
     * @param calendar  根据日历对象来获取一年中有多少天
     * @return  计算后日期间隔的天数
     */
    public static int numerical(int maxDays, int d1, int d2, int y1, int y2, Calendar calendar){
        int day = d1 - d2;
        int betweenYears = y1 - y2;
        List<Integer> d366 = new ArrayList<Integer>();
        if(calendar.getActualMaximum(Calendar.DAY_OF_YEAR) == 366){
            day += 1;
        }

        for (int i = 0; i < betweenYears; i++) {
            // 当年 + 1 设置下一年中有多少天
            calendar.set(Calendar.YEAR, (calendar.get(Calendar.YEAR)) + 1);
            maxDays = calendar.getActualMaximum(Calendar.DAY_OF_YEAR);
            // 第一个 366 天不用 + 1 将所有366记录，先不进行加入然后再少加一个
            if(maxDays != 366){
                day += maxDays;
            }else{
                d366.add(maxDays);
            }
            // 如果最后一个 maxDays 等于366 day - 1
            if(i == betweenYears-1 && betweenYears > 1 && maxDays == 366){
                day -= 1;
            }
        }

        for(int i = 0; i < d366.size(); i++){
            // 一个或一个以上的366天
            if(d366.size() >= 1){
                day += d366.get(i);
            }
//          else{
//              day -= 1;
//          }
        }
        return day;
    }

    /**
     *
     * 功能描述：substring
     * 创建于：2015-5-14 下午06:56:49
     * 作者： Gemini
     * @param src
     * @param start_idx
     * @param end_idx
     * @return
     * 返回：String
     */
    public static String substring(String src, int start_idx, int end_idx){
        byte[] b = src.getBytes();
        String tgt = "";
        for(int i=start_idx; i<=end_idx; i++){
            tgt +=(char)b[i];
        }
        return tgt;
    }
    /**
     * 判断字符串不为空
     * @param param
     * @return
     */
    public static Boolean isNotNull(String param){
        if(null!=param && !"".equals(param)){
            return true;
        }else{
            return false;
        }
    }

}
