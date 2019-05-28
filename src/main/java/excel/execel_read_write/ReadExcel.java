package excel.execel_read_write;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * 读取Excel文件的方法
 * @author lmb
 * @date 2017-3-15
 *
 */
public class ReadExcel {

    private static String xls2003 = "D:\\employee.xls";
    private static String xlsx2007 = "D:\\employee.xlsx";

    /**
     * 读取Excel2003的主表数据 （单个sheet）
     * @param filePath
     * @return
     */
    private static List<Employee> readFromXLS2003(String filePath) {
        File excelFile = null;// Excel文件对象
        InputStream is = null;// 输入流对象
        String cellStr = null;// 单元格，最终按字符串处理
        List<Employee> employeeList = new ArrayList<Employee>();// 返回封装数据的List
        Employee employee = null;// 每一个雇员信息对象
        try {
            excelFile = new File(filePath);
            is = new FileInputStream(excelFile);// 获取文件输入流
            HSSFWorkbook workbook2003 = new HSSFWorkbook(is);// 创建Excel2003文件对象
            HSSFSheet sheet = workbook2003.getSheetAt(0);// 取出第一个工作表，索引是0
            // 开始循环遍历行，表头不处理，从1开始
            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                HSSFRow row = sheet.getRow(i);// 获取行对象
                employee = new Employee();// 实例化Student对象
                if (row == null) {// 如果为空，不处理
                    continue;
                }
                // 循环遍历单元格
                for (int j = 0; j < row.getLastCellNum(); j++) {
                    HSSFCell cell = row.getCell(j);// 获取单元格对象
                    if (cell == null) {// 单元格为空设置cellStr为空串
                        cellStr = "";
                    } else if (cell.getCellType() == HSSFCell.CELL_TYPE_BOOLEAN) {// 对布尔值的处理
                        cellStr = String.valueOf(cell.getBooleanCellValue());
                    } else if (cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {// 对数字值的处理
                        cellStr = cell.getNumericCellValue() + "";
                    } else {// 其余按照字符串处理
                        cellStr = cell.getStringCellValue();
                    }
                    // 下面按照数据出现位置封装到bean中
                    if (j == 0) {
                        employee.setName(cellStr);
                    } else if (j == 1) {
                        employee.setGender(cellStr);
                    } else if (j == 2) {
                        employee.setAge(new Double(cellStr).intValue());
                    } else if (j == 3) {
                        employee.setDepartment(cellStr);
                    } else if(j == 4){
                        employee.setSalary(new Double(cellStr).intValue());
                    }else {
                        employee.setDate(cellStr);
                    }
                }
                employeeList.add(employee);// 数据装入List
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {// 关闭文件流
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return employeeList;
    }

    /**
     * 读取Excel2003的表头
     * @param filePath 需要读取的文件路径
     * @return
     */
    public static String[] readHeaderFromXLS2003(String filePath){
        String[] excelTitle = null;
        FileInputStream is = null;
        try{
            File excelFile = new File(filePath);
            is = new FileInputStream(excelFile);
            HSSFWorkbook workbook2003 = new HSSFWorkbook(is);
            //循环读取工作表
            for (int i = 0; i < workbook2003.getNumberOfSheets(); i++) {
                HSSFSheet hssfSheet = workbook2003.getSheetAt(i);
                //*************获取表头是start*************
                HSSFRow sheetRow = hssfSheet.getRow(i);
                excelTitle = new String[sheetRow.getLastCellNum()];
                for (int k = 0; k < sheetRow.getLastCellNum(); k++) {
                    HSSFCell hssfCell = sheetRow.getCell(k);
                    excelTitle[k] = hssfCell.getStringCellValue();
//		            	System.out.println(excelTitle[k] + " ");
                }
                //*************获取表头end*************
            }
        }catch (IOException e) {
            e.printStackTrace();
        } finally {// 关闭文件流
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return excelTitle;
    }

    /**
     * 读取Excel2007的示例方法 （单个sheet）
     * @param filePath
     * @return
     */
    public static List<Employee> readFromXLSX2007(String filePath) {
        File excelFile = null;// Excel文件对象
        InputStream is = null;// 输入流对象
        String cellStr = null;// 单元格，最终按字符串处理
        List<Employee> studentList = new ArrayList<Employee>();// 返回封装数据的List
        Employee employee = null;// 每一个雇员信息对象
        try {
            excelFile = new File(filePath);
            is = new FileInputStream(excelFile);// 获取文件输入流
//            XSSFWorkbook workbook2007 = new XSSFWorkbook(is);// 创建Excel2007文件对象
            org.apache.poi.ss.usermodel.Workbook workbook2007 = WorkbookFactory.create(is);
//            XSSFSheet sheet = workbook2007.getSheetAt(0);// 取出第一个工作表，索引是0
            org.apache.poi.ss.usermodel.Sheet sheet = workbook2007.getSheetAt(0);
            // 开始循环遍历行，表头不处理，从1开始
            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                employee = new Employee();// 实例化Student对象
//            	HSSFRow row = sheet.getRow(i);// 获取行对象
                Row row = sheet.getRow(i);// 获取行对象
                if (row == null) {// 如果为空，不处理
                    continue;
                }
                // 循环遍历单元格
                for (int j = 0; j < row.getLastCellNum(); j++) {
//                    XSSFCell cell = row.getCell(j);// 获取单元格对象
                    Cell cell = row.getCell(j);// 获取单元格对象
                    if (cell == null) {// 单元格为空设置cellStr为空串
                        cellStr = "";
                    } else if (cell.getCellType() == HSSFCell.CELL_TYPE_BOOLEAN) {// 对布尔值的处理
                        cellStr = String.valueOf(cell.getBooleanCellValue());
                    } else if (cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {// 对数字值的处理
                        cellStr = cell.getNumericCellValue() + "";
                    } else {// 其余按照字符串处理
                        cellStr = cell.getStringCellValue();
                    }
                    // 下面按照数据出现位置封装到bean中
                    if (j == 0) {
                        employee.setName(cellStr);
                    } else if (j == 1) {
                        employee.setGender(cellStr);
                    } else if (j == 2) {
                        employee.setAge(new Double(cellStr).intValue());
                    } else if (j == 3) {
                        employee.setDepartment(cellStr);
                    } else if(j == 4){
                        employee.setSalary(new Double(cellStr).intValue());
                    } else {
                        employee.setDate(cellStr);
                    }
                }
                studentList.add(employee);// 数据装入List
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InvalidFormatException e) {
            // TODO Auto-generated catch block
        }finally {// 关闭文件流
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return studentList;
    }

    /**
     * 读取Excel的示例方法 （多个sheet）
     * @param filePath
     * @return
     */
    public List<Employee> readMoreSheetFromXLS(String filePath){
        List<Employee> employeeList = new ArrayList<Employee>();
        String cellStr = null;//单元格，最终按字符串处理
        //创建来自excel文件的输入流
        try {
            FileInputStream is = new FileInputStream(filePath);
            //创建WorkBook实例
            Workbook workbook = null;
            if (filePath.toLowerCase().endsWith("xls")) {//2003
                workbook = new HSSFWorkbook(is);
            }else if(filePath.toLowerCase().endsWith("xlsx")){//2007
                workbook = WorkbookFactory.create(is);
            }
            //获取excel文件的sheet数量
            int numOfSheets = workbook.getNumberOfSheets();
            //挨个遍历sheet
            for (int i = 0; i < numOfSheets; i++) {
                Sheet sheet = workbook.getSheetAt(i);
                //挨个遍历sheet的每一行
                for (Iterator<Row> iterRow = sheet.iterator();iterRow.hasNext();) {
                    Row row = iterRow.next();
                    Employee employee = new Employee();
                    int j = 0;//标识位，用于标识第几列
                    //挨个遍历每一行的每一列
                    for (Iterator<Cell> cellIter = row.cellIterator();cellIter.hasNext();) {
                        Cell cell = cellIter.next();//获取单元格对象
                        if (j == 0) {
                            if (cell == null) {// 单元格为空设置cellStr为空串
                                cellStr = "";
                            } else if (cell.getCellType() == HSSFCell.CELL_TYPE_BOOLEAN) {// 对布尔值的处理
                                cellStr = String.valueOf(cell.getBooleanCellValue());
                            } else if (cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {// 对数字值的处理
                                cellStr = cell.getNumericCellValue() + "";
                            } else {// 其余按照字符串处理
                                cellStr = cell.getStringCellValue();
                            }
                            employee.setName(cellStr);
                            j ++;
                        }
//						employee.setGender(cellStr); j == 1
//						employee.setAge(new Double(cellStr).intValue()); j == 2
//						employee.setDepartment(cellStr); j == 3
//						employee.setSalary(new Double(cellStr).intValue());  j == 4
//						employee.setDate(cellStr); j == 5
                        employeeList.add(employee);
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        }
        return employeeList;
    }

    /**
     * 主函数
     *
     * @param args
     */
    public static void main(String[] args) {
        String str = "2344.0";
        
        System.out.println("************读取Excel2003的主表数据（将Excel单元格设为文本格式）******************");
        long start2003 = System.currentTimeMillis();
        List<Employee> list2003 = readFromXLS2003(xls2003);
        for (Employee employee : list2003) {
            System.out.println(employee);
        }
        long end2003 = System.currentTimeMillis();
        System.out.println((end2003 - start2003) + " ms done!");
        System.out.println("***********读取Excel2007的主表数据（未将Excel单元格设为文本格式） *********************");
        long start2007 = System.currentTimeMillis();
        List<Employee> list2007 = readFromXLSX2007(xlsx2007);
        for (Employee employee : list2007) {
            System.out.println(employee);
        }
        long end2007 = System.currentTimeMillis();
        System.out.println((end2007 - start2007) + " ms done!");
        System.out.println("************读取Excel2003的表头**********************");
        String[] excelTitle = readHeaderFromXLS2003(xls2003);
        StringBuffer title = new StringBuffer();
        for (int i = 0; i < excelTitle.length; i++) {
            title.append(excelTitle[i] + " ");
        }
        System.out.println(title.toString());
    }

    /*	运行结果：http://stackoverflow.com/questions/21992071/org-apache-poi-poixmlexception-org-apache-poi-openxml4j-exceptions-invalidforma
        ************读取Excel2003的主表数据（将Excel单元格设为文本格式）******************
		Employee [name=Tom, gender=男, age=29, department=信息技术部, salary=6800.0, date=20170316]
		Employee [name=Jack, gender=男, age=25, department=质量保障部, salary=6800.0, date=20170316]
		Employee [name=May, gender=女, age=26, department=公共关系部, salary=6800.0, date=20170316]
		Employee [name=Mary, gender=女, age=27, department=财务部, salary=6800.0, date=20170316]
		Employee [name=Sarah, gender=女, age=28, department=电销部, salary=6800.0, date=20170316]
		268 ms done!
     	***********读取Excel2007的主表数据 （未将Excel单元格设为文本格式）*********************
		Employee [name=Tom, gender=男, age=29, department=信息技术部, salary=6800.0, date=42810.0]
		Employee [name=Jack, gender=男, age=25, department=质量保障部, salary=6800.0, date=42810.0]
		Employee [name=May, gender=女, age=26, department=公共关系部, salary=6800.0, date=42810.0]
		Employee [name=Mary, gender=女, age=27, department=财务部, salary=6800.0, date=42810.0]
		Employee [name=Sarah, gender=女, age=28, department=电销部, salary=6800.0, date=42810.0]
		924 ms done!
     	************读取Excel2003的表头**********************
		姓名 性别 年龄 部门 薪资 日期
    */
}
