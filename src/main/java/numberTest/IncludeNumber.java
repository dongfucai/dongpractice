package numberTest;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Package Name : ${PACKAG_NAME}
 * @Author : dongfucai@meituan.com
 * @Creation Date : 2019年02月12日下午2:52
 * @Function : todo
 */
public class IncludeNumber {

    public static void main(String[] args) {


        System.out.println(HasDigit("KL3434334"));
        System.out.println(HasDigit("KLssdfnotexist"));
    }

    // 判断一个字符串是否含有数字
    public static boolean HasDigit(String content) {
        boolean flag = false;
        Pattern p = Pattern.compile(".*\\d+.*");
        Matcher m = p.matcher(content);
        if (m.matches()) {
            flag = true;
        }
        return flag;
    }

}
