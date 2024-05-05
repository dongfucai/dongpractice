//package excel.yaoshuang;
//
//import excel.yaoshuang.vo.HandlerContext;
//import excel.yaoshuang.vo.RowInfoVo;
//import org.apache.commons.collections4.CollectionUtils;
//import org.apache.poi.hssf.usermodel.HSSFCell;
//import org.apache.poi.hssf.usermodel.HSSFWorkbook;
//import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.ss.usermodel.Sheet;
//import org.apache.poi.ss.usermodel.Workbook;
//import org.apache.poi.util.IOUtils;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.util.Date;
//import java.util.List;
//
///**
// * @Author dongfucai/1766318593@qq.com
// * @Description //TODO
// * @Date 2019/8/8 上午12:04
// * @Version 1.0
// **/
//
//public class WriteExcelHandler implements Handler{
//
//    @Override
//    public void handleData(HandlerContext<RowInfoVo> staffBatchVOHandlerContext) {
//
//
//
//    }
//
//
//    //按照Workbook，Sheet， Row， Cell依次创建，并将数据写入cell中 同理先初始化Workbook
//    private static Workbook getWriteWorkBoolType(String filePath) throws Exception {
//        if (filePath.toLowerCase().endsWith("xlsx")) {
//            return new XSSFWorkbook();
//        } else if (filePath.toLowerCase().endsWith("xls")) {
//            return new HSSFWorkbook();
//        } else {
//            //default
//            return new XSSFWorkbook();
//        }
//    }
//
//
//    public static void writeExcel(String targetFilePath, HandlerContext<RowInfoVo> staffBatchVOHandlerContext) throws Exception {
//        Workbook workbook = null;
//        FileOutputStream fos = null;
//
//        workbook = getWriteWorkBoolType(targetFilePath);
//
//        if (workbook == null) {
//            staffBatchVOHandlerContext.getHandlerStringBuilder().append("get write workbook=null;");
//            return;
//        }
//        // title
//        generateTitleWrite(workbook);
//        // data write
//        generateSheetDataWrite(workbook, staffBatchVOHandlerContext);
//        //写入到文件流中
//        try {
//            fos = new FileOutputStream(targetFilePath);
//            workbook.write(fos);
//        } catch (IOException e) {
//            staffBatchVOHandlerContext.getHandlerStringBuilder().append("文件写入错误;");
//            throw e;
//        } finally {
//            if (fos != null) {
//                try {
//                    fos.close();
//                } catch (IOException e) {
//                }
//
//            }
//            IOUtils.closeQuietly(workbook);
//        }
//    }
//
//    private static void generateTitleWrite(Workbook workbook) {
//        if (workbook == null) {
//            workbook = new XSSFWorkbook();
//        }
//
//        //创建sheet
//        Sheet sheet = workbook.createSheet("工作表");
//        //在sheet第一行写出表单的各个字段名
//        Row titleRow = sheet.createRow(0);
//        int col = 0;
//        titleRow.createCell(col++).setCellValue("账号类型");
//        titleRow.createCell(col++).setCellValue("账号");
//        titleRow.createCell(col++).setCellValue("姓名");
//        titleRow.createCell(col++).setCellValue("邮箱");
//        titleRow.createCell(col++).setCellValue("手机号");
//        titleRow.createCell(col++).setCellValue("身份证号");
//        titleRow.createCell(col++).setCellValue("上级(mis)");
//        titleRow.createCell(col++).setCellValue("部门1");
//        titleRow.createCell(col++).setCellValue("部门2");
//
//
//
//    }
//
//    private static void generateSheetDataWrite(Workbook workbook, HandlerContext<RowInfoVo> staffBatchVOHandlerContext) {
//
//        List<RowInfoVo> staffBatchVOList = null;
//        if (workbook != null && staffBatchVOHandlerContext != null && CollectionUtils.isNotEmpty(staffBatchVOList = staffBatchVOHandlerContext.getHandlerList())) {
//            Sheet sheet = workbook.getSheetAt(0);
//            if (sheet == null) {
//                return;
//            }
//
//            //每行的单元格一次写入
//            for (int i = 0; i < staffBatchVOList.size(); ++i) {
//                //第1行作为表格列名，所以从第2行开始读取
//                Row row = sheet.createRow(i + 1);
//                //row.setRowStyle(HSSFCell.ENCODING_UTF_16);
//                if (row == null) {
//                    return;
//                }
//                int col = 0;
//
//                row.createCell(col++).setCellValue(judgeIsNull(staffBatchVOList.get(i).getStaffTypeName()));
//                row.createCell(col++).setCellValue(judgeIsNull(staffBatchVOList.get(i).getLoginName()));
//                row.createCell(col++).setCellValue(judgeIsNull(staffBatchVOList.get(i).getName()));
//                row.createCell(col++).setCellValue(judgeIsNull(staffBatchVOList.get(i).getEmail()));
//                row.createCell(col++).setCellValue(judgeIsNull(staffBatchVOList.get(i).getMobile()));
//                row.createCell(col++).setCellValue(judgeIsNull(staffBatchVOList.get(i).getIdCard()));
//                row.createCell(col++).setCellValue(judgeIsNull(staffBatchVOList.get(i).getLeaderMisName()));
//                row.createCell(col++).setCellValue(judgeIsNull(staffBatchVOList.get(i).getLevelName()));
//                row.createCell(col++).setCellValue(judgeIsNull(staffBatchVOList.get(i).getDepartmentName()));
//                row.createCell(col++).setCellValue(judgeIsNull(staffBatchVOList.get(i).getAgentTypeName()));
//
//
//
//            }
//        }
//    }
//
//    private static <T> String judgeIsNull(T e) {
//        if (e == null) {
//            return "";
//        }
//        if (e instanceof Date) {
//            return e.toString();
//        }
//        if (e instanceof Number) {
//            return e.toString();
//        }
//        return e.toString();
//    }
//
//}
