package excel.yaoshuang;

import com.google.common.collect.Lists;
import excel.yaoshuang.vo.HandlerContext;
import excel.yaoshuang.vo.RowInfoVo;
import org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.util.IOUtils;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import util.JacksonUtil;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.List;

import static org.apache.poi.ss.usermodel.CellType.NUMERIC;

/**
 * @Author dongfucai/1766318593@qq.com
 * @Description //TODO
 * @Date 2019/8/7 下午11:24
 * @Version 1.0
 **/

public class ParseExecelHandler implements Handler{

    @Override
    public void handleData(HandlerContext<RowInfoVo> staffBatchVOHandlerContext) {


    }

    private static void readExcel(HandlerContext<RowInfoVo> rowInfoVoHandlerContex) {
        Workbook workbook = null;
        try {
            workbook = getReadWorkBookType(rowInfoVoHandlerContex.getFilePath());

            if (workbook == null) {
                return;
            }

            List<RowInfoVo> rowInfoVoList = Lists.newLinkedList();
            //获取第一个sheet
            //workbook.getActiveSheetIndex()
            Sheet sheet = workbook.getSheetAt(0);
            if (sheet == null) {
                return;
            }


            //第0行是表名，忽略，从第二行开始读取
            for (int rowNum = 1; rowNum <= sheet.getLastRowNum(); rowNum++) {
                RowInfoVo rowInfoVo = new RowInfoVo();
                int colNum = 0;
                Row row = sheet.getRow(rowNum);
                if (row == null) {
                    continue;
                }

                // 错误码
                rowInfoVo.setErrorCode(getCellStringVal(row.getCell(colNum++)));
                // 语言
                rowInfoVo.setCn(getCellStringVal(row.getCell(colNum++)));
                // 展现错误信息（个人网银）
                rowInfoVo.setShowErrorInfo(getCellStringVal(row.getCell(colNum++)));
                // 内部错误信息
                rowInfoVo.setInnerErrorInfo(getCellStringVal(row.getCell(colNum++)));
                // 生效系统，个人网银只取0-全部，1-个人网银
                rowInfoVo.setValidSystem(getCellStringVal(row.getCell(colNum++)));
                // 状态0-有效
                rowInfoVo.setStatus(getCellStringVal(row.getCell(colNum++)));
                // 展示错误信息(BP)
                rowInfoVo.setErrorInfoBP(getCellStringVal(row.getCell(colNum++)));


                if (rowInfoVoList.size() == 10) {
                    break;
                }
                rowInfoVoList.add(rowInfoVo);
            }
            rowInfoVoHandlerContex.setHandlerList(rowInfoVoList);

            System.out.println(JacksonUtil.toJsonStrWithEmptyDefault(rowInfoVoHandlerContex));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            rowInfoVoHandlerContex.getHandlerStringBuilder().append("ParseHandler exception;" + e.getMessage());
        } finally {
            IOUtils.closeQuietly(workbook);
        }
    }

    private static String getCellStringVal(Cell cell) {
        if (cell == null) {
            return "";
        }
        CellType cellType = cell.getCellTypeEnum();
        DecimalFormat df = new DecimalFormat("#");

        switch (cellType) {
            case NUMERIC:
                //double d = cell.getNumericCellValue();
                //return  String.valueOf((int)d);
                //return String.valueOf(cell.getCellComment());
                //return subZeroAndDot(String.valueOf(cell.getNumericCellValue())).trim();
                return df.format(cell.getNumericCellValue());
            case STRING:
                return cell.getStringCellValue().trim();
            case BOOLEAN:
                return String.valueOf(cell.getBooleanCellValue()).trim();
            case FORMULA:
                return cell.getCellFormula().trim();
            case BLANK:
                return "";
            case ERROR:
                return String.valueOf(cell.getErrorCellValue());
            default:
                return StringUtils.EMPTY;
        }
    }

    private static Integer getCellIntegerVal(Cell cell) {
        if (cell == null) {
            return null;
        }
        CellType cellType = cell.getCellTypeEnum();
        if (cellType == NUMERIC) {
            return (int) cell.getNumericCellValue();
        }
        return null;
    }

    /**
     * 使用java正则表达式去掉多余的.与0
     *
     * @param s
     * @return
     */
    public static String subZeroAndDot(String s) {
        if (s.indexOf(".") > 0) {
            s = s.replaceAll("0+?$", "");//去掉多余的0
            s = s.replaceAll("[.]$", "");//如最后一位是.则去掉
        }
        return s;
    }


    //按照Workbook，Sheet， Row， Cell依次创建，并将数据写入cell中 同理先初始化Workbook
    private static Workbook getReadWorkBookType(String filePath) throws Exception{
        //xls-2003, xlsx-2007
        FileInputStream is = null;

        try {
            is = new FileInputStream(filePath);
            if (filePath.toLowerCase().endsWith("xlsx")) {
                return new XSSFWorkbook(is);
            } else if (filePath.toLowerCase().endsWith("xls")) {
                return new HSSFWorkbook(is);
            } else {
                //  抛出自定义的业务异常
                //throw OnlinePayErrorCode.EXCEL_ANALYZE_ERROR.convertToException("excel格式文件错误");
                return null;
            }
        } catch (IOException e) {
            //  抛出自定义的业务异常
            throw e;
            //throw OnlinePayErrorCode.EXCEL_ANALYZE_ERROR.convertToException(e.getMessage());
        } finally {
            IOUtils.closeQuietly(is);
        }
    }


    public static void main(String[] args) {

        String path = "/Users/dongfucai/Downloads/yaoshuang/code.xlsx";
        HandlerContext<RowInfoVo> handlerContext = new HandlerContext<>();
        handlerContext.setFilePath(path);

        readExcel(handlerContext);

    }




}
