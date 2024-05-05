import com.google.common.collect.Lists;

import java.math.BigDecimal;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/**
 * @Author dongfucai/1766318593@qq.com
 * @Description //TODO
 * @Date 2019/11/4 下午5:08
 * @Version 1.0
 **/

public class Test {

    public static void main(String[] args) throws Exception{


//        List<String> list = Lists.newArrayList();
//
//        list.add("sdf");
//        list.add("abd");
//
//        list.add("124");
//        list.add("sdfsfsdsdf");
//
//        Iterator it = list.iterator();
//
//        while (it.hasNext()) {
//            String str = (String)it.next();
//
//
//            if (str.equals("abd")) {
//                list.remove(str);
//            }
//        }


//        BigDecimal numberDecimal = new BigDecimal("23.33");
//        System.out.println(numberDecimal);
//
//        BigDecimal bigDecimal = new BigDecimal("sfdsdfsd");
//        System.out.println(bigDecimal);


//        List<Integer> arr = null;
//        for (Integer ele : arr) {
//            System.out.println(ele);
//        }

        /**
         * [B@49097b5d
         * [B@6e2c634b
         */

        String csn = Charset.defaultCharset().name();

        System.out.println(csn);
        String str1 = "董付财";
        System.out.println(str1.getBytes());
        System.out.println(str1.getBytes("UTF-8"));



        String str = "严";
        System.out.println("str="+str);
        System.out.println("str len=" + str.length());
        System.out.println("str getBytes=" + str.getBytes().length+"  HEX="+bytes2HexString(str.getBytes()));
        System.out.println("str getBytes UTF-8=" + str.getBytes("UTF-8").length+"  HEX="+bytes2HexString(str.getBytes("UTF-8")));
        System.out.println("str getBytes UTF-16=" + str.getBytes("UTF-16").length+"  HEX="+bytes2HexString(str.getBytes("UTF-16")));
        System.out.println("str getBytes UTF-16BE=" + str.getBytes("UTF-16BE").length+"  HEX="+bytes2HexString(str.getBytes("UTF-16BE")));
        System.out.println("str getBytes UTF-16LE=" + str.getBytes("UTF-16LE").length+"  HEX="+bytes2HexString(str.getBytes("UTF-16LE")));
        System.out.println("str getBytes Unicode=" + str.getBytes("Unicode").length+"  HEX="+bytes2HexString(str.getBytes("Unicode")));



    }

    /**
     * byte[] 转为16进制String
     */
    public static String bytes2HexString(byte[] b) {
        String ret = "";
        for (int i = 0; i < b.length; i++) {
            String hex = Integer.toHexString(b[i] & 0xFF);
            if (hex.length() == 1) {
                hex = '0' + hex;
            }
            ret += hex.toUpperCase();
        }
        return ret;
    }


    @Override
    public String toString() {
        return super.toString();
    }
}
