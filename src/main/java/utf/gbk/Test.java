package utf.gbk;

import utf.gbk.EncodingUtil;

import java.io.IOException;
import java.nio.charset.Charset;

public class Test {

//	一
//	GB2312编码：D2BB BIG5编码：A440 GBK编码：D2BB GB18030编码：D2BB Unicode编码：4E00 ,utf-8: E4B880
//	丁
//	GB2312编码：B6A1 BIG5编码：A442 GBK编码：B6A1 GB18030编码：B6A1 Unicode编码：4E01 ,utf-8: E4B881
//	丂
//	GB2312编码：没有 BIG5编码：没有 GBK编码：8140 GB18030编码：8140 Unicode编码：4E02 ,utf-8: E4B882
//	七
//	GB2312编码：C6DF BIG5编码：A443 GBK编码：C6DF GB18030编码：C6DF Unicode编码：4E03 ,utf-8: E4B883
//  \r\n  ： 0A 0D
//  0-9 : 30 39
//  A-Z : 41~5A  a-z : 61~7A

//  一18丁a丂七40
// GBK      ： D2BB 3138 B6A1 61 8140 C6DF 3430
// unicode  : 4E00 3138 4E01 61 4E02 4E03 3430
// utf-8    : E4B880 3138 E4B881 61 E4B882 E4B883 3430

    public static void main(String[] args) throws IOException {

        System.out.println("start");

        //String s = "一18丁a丂七40";

        String s = "严";


        System.out.println("系统默认编码： " + System.getProperty("file.encoding"));// 查询结果GBK
        // 系统默认字符编码
        System.out.println("系统默认字符编码:" + Charset.defaultCharset()); // 查询结果GBK
        // 操作系统用户使用的语言
        System.out.println("系统默认语言:" + System.getProperty("user.language")); // 查询结果zh

        // 使用系统默认的字符编码
        byte[] defaultCharsetArr = s.getBytes();
        showByteArr(defaultCharsetArr,"defaultCharsetArr");

        // unicode编码，在java所有字符（中英文）均占2个字节
        byte[] unicodeArr = s.getBytes("unicode");
        showByteArr(unicodeArr,"unicodeArr");

        // gbk中文占2个字节，UTF-8k中文占3个字节; 英文字符2者均占1个字节

        byte[] gbkArr = s.getBytes("gbk");
        showByteArr(gbkArr,"gbkArr");

        byte[] utf8Arr = s.getBytes("utf-8");
        showByteArr(utf8Arr,"utf8Arr");

        // ISO-8859-1编码中不能出现中文，因为其将每个中文字符编码为1个字节（非法）
        // 会造成字节的丢失
        byte[] isoArr = s.getBytes("ISO-8859-1");
        showByteArr(isoArr,"isoArr");

        // gbk to utf-8
        showByteArr(EncodingUtil.convertEncoding_ByteArr(gbkArr,"gbk","utf-8"),"gbk to utf-8");
        showByteArr(EncodingUtil.convertEncoding_ByteArr(utf8Arr,"utf-8","gbk"),"utf-8 to gbk");
        showByteArr(EncodingUtil.convertEncoding_ByteArr(utf8Arr,"utf-8","unicode"),"utf-8 to unicode");

        System.out.println("end");

    }

    private static void showByteArr(byte[] arr,String msg) {
        // TODO Auto-generated method stub
        System.out.println(msg);
        System.out.println("byte[] len=:" + arr.length + "\n" + EncodingUtil.byteToHex(arr));
    }

}

