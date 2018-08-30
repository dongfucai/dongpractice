package excel;

import com.csvreader.CsvWriter;
import com.sun.org.apache.xpath.internal.operations.Number;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/**
 * @Package Name : ${PACKAG_NAME}
 * @Author : dongfucai@meituan.com
 * @Creation Date : 2018年05月31日上午11:10
 * @Function : todo
 */
public class CsvOwn {

    static char separator = ',';
    public static void main(String[] args) throws Exception{
        // 测试导出
        String filePath = "./testown.csv";
        List<String[]> dataList = new ArrayList<String[]>();
        for (int i = 0; i < 10; i++) {
            dataList.add(new String[] { "0" + i, "小明" + i, "java" + i });
            for (String s:dataList.get(i)){
                System.out.print(s+",");
            }
            System.out.println();

        }


        List<List> result = new ArrayList<>();


        for(int i=0;i<10;++i) {
            List<Object> objects = new ArrayList<>();
            for(int j=0;j<10;++j) {
                objects.add("sfs");
                objects.add(232);
            }
            result.add(objects);

        }



        exportCsv(dataList, result, generateTitles(),filePath);



    }


    /**
     *  java 导出 cvs 文件
     *
     *  @param dataList
     *
     *  @Param filePath
     *
     */

    public static boolean exportCsv(List<String[]> dataList, List<List> excelExportData, List<String> titles,String filePath) throws Exception{
        boolean isSuccess =  false;
        CsvWriter writer = null;
        FileOutputStream out = null;

        try {
            out = new FileOutputStream(filePath, false);
            writer = new CsvWriter(out, separator, Charset.forName("GBK"));
            for (String[] strs : dataList) {
                writer.writeRecord(strs);
            }
            for (String str:titles){
                writer.write(str);
            }
            writer.endRecord();
            for (String str:titles){
                writer.write(str);
            }

            writer.endRecord();

            for (List list:excelExportData){
                for (Object dataObj:list){
                    if (dataObj == null){
                        writer.write("");
                    } else if (dataObj instanceof Number){
                        writer.write(String.valueOf(dataObj));
                    } else{
                        writer.write(String.valueOf(dataObj));
                    }
                }
                writer.endRecord();
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

    public static  List<String> generateTitles() {
        List<String> titleList = new ArrayList<>();
        titleList.add("工单ID");
        titleList.add("工单类别ID");
        titleList.add("工单类别名称");
        titleList.add("工单状态ID");
        titleList.add("工单状态名称");
        titleList.add("创建人ID");
        titleList.add("创建人名称");
        titleList.add("创建人工号");
        titleList.add("创建人账号名");
        titleList.add("创建人部门名称");
        titleList.add("处理人ID");
        titleList.add("处理人名称");
        titleList.add("处理人工号");
        titleList.add("处理人账号名");
        titleList.add("处理人部门名称");
        titleList.add("更新人ID");
        titleList.add("更新人名称");
        titleList.add("更新人工号");
        titleList.add("更新人账号名");
        titleList.add("更新人部门名称");
        titleList.add("关单人ID");
        titleList.add("关单人名称");
        titleList.add("关单人工号");
        titleList.add("关单人账号名");
        titleList.add("关单人部门名称");
        titleList.add("客户ID");
        titleList.add("客户类型ID");
        titleList.add("客户类型");

        titleList.add("1级问题ID");
        titleList.add("1级问题");
        titleList.add("2级问题ID");
        titleList.add("2级问题");
//        for(int i = 0; i <= faqSize; i++){
//            int curNum = i + 3;
//            titleList.add( curNum +"级问题ID");
//            titleList.add( curNum + "级问题");
//        }
        titleList.add("问题答案原因ID");
        titleList.add("问题答案原因名称");
        titleList.add("创建时间");
        titleList.add("更新时间");
        titleList.add("预计结案时间");
        titleList.add("当前生命周期开始时间");
//        titleList.add("订单ID");
//        titleList.add("订单类型ID");
//        titleList.add("订单类型");
        titleList.add("渠道ID");
        titleList.add("渠道描述");
        titleList.add("来源ID");
        titleList.add("来源描述");

        titleList.add("反馈内容");
        titleList.add("工单优先级ID");
        titleList.add("工单优先级描述");
        titleList.add("关单时间");
        titleList.add("回访时间");
        titleList.add("反馈联系方式");
        return titleList;
    }
}
