package excel.execel_read_write;

import lombok.Data;

/**
 * @Package Name : ${PACKAG_NAME}
 * @Author : dongfucai@meituan.com
 * @Creation Date : 2019年01月11日下午4:06
 * @Function : todo
 */
@Data
public class Employee {

    private String name;
    private String gender;
    private int age;
    private String department;
    private double salary;
    /**
     * 注意：读取日期操作要将Excel单元格设为文本格式，然后按字符串读取；写入操作时，直接按字符串写入
     */
    private String date;
    public Employee() {
        super();
    }
    public Employee(String name, String gender, int age, String department,
                    double salary, String date) {
        super();
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.department = department;
        this.salary = salary;
        this.date = date;
    }
    //省略getter/setter方法
    @Override
    public String toString() {
        return "Employee [name=" + name + ", gender=" + gender + ", age=" + age
                + ", department=" + department + ", salary=" + salary
                + ", date=" + date + "]";
    }
}
