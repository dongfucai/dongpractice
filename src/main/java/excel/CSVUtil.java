package excel;

import com.csvreader.CsvWriter;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/**
 * @Package Name : ${PACKAG_NAME}
 * @Author : dongfucai@meituan.com
 * @Creation Date : 2018年05月30日下午3:28
 * @Function : todo
 */
public class CSVUtil {

    static char separator = ',';
    public static void main(String[] args) throws Exception{
        // 测试导出
        String filePath = "./test.csv";
        List<String[]> dataList = new ArrayList<String[]>();
        for (int i = 0; i < 10; i++) {
            dataList.add(new String[] { "0" + i, "小明" + i, "java" + i });
            for (String s:dataList.get(i)){
                System.out.print(s+",");
            }
            System.out.println();

        }
//System.out.println(Arrays.toString(arr));

        exportCsv(dataList, filePath);



    }


    /**
     *  java 导出 cvs 文件
     *
     *  @param dataList
     *
     *  @Param filePath
     *
     */

    public static boolean exportCsv(List<String[]> dataList, String filePath) throws Exception{
        boolean isSuccess =  false;
        CsvWriter writer = null;
        FileOutputStream out = null;

        try {
            out = new FileOutputStream(filePath, false);
            writer = new CsvWriter(out, separator, Charset.forName("GBK"));
            for (String[] strs : dataList) {
                writer.writeRecord(strs);
            }

            isSuccess = true;
        } catch (Exception e) {
            System.out.println("生成CSV出错..." + e);
            throw e;
        } finally {
            if (null != writer) {
                writer.close();
            }
            if (null != out) {
                try {
                    out.close();
                } catch (IOException e) {
                    System.out.println("exportCsv close Exception: " + e);
                    throw e;
                }
            }
        }



        return isSuccess;

    }


}
