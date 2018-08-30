package super1;
import lombok.Data;

/**
 * @Package Name : ${PACKAG_NAME}
 * @Author : dongfucai@meituan.com
 * @Creation Date : 2018年05月12日下午4:52
 * @Function : todo
 */

class Country1 {
    String name;
    void value() {
         name = "China";
    }
}
//super可以理解为是指向自己超（父）类对象的一个指针，而这个超类指的是离自己最近的一个父类。
//可以看到，这里既调用了父类的方法，也调用了父类的变量。若不调用父类方法value()，
// 只调用父类变量name的话，则父类name值为默认值null。
//

@Data
public class City extends Country1{
        private  String name;
        public  void value() {
            name = "Shanghai";
            super.value();      //调用父类的方法
            System.out.println(name);
            System.out.println(super.name);
        }

        public static void main(String[] args) {
             City c=new City();

              c.value();
              c.setName("skfsds");
            System.out.println(c.getName());

            System.out.println(System.currentTimeMillis());
        }


}
