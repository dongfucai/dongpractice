package IntrospectorDe;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;

/**
 * @Package Name : ${PACKAG_NAME}
 * @Author : 1766318593@qq.com
 * @Creation Date : 2018年09月27日下午5:52
 * @Function : todo
 */

/**
 *
 内省是 Java 语言对 Bean 类属性、事件的一种缺省处理方法。
 例如类 A 中有属性 name, 那我们可以通过 getName,setName 来得到其值或者设置新的值。
 通过 getName/setName 来访问 name 属性，这就是默认的规则。
 Java 中提供了一套 API 用来访问某个属性的 getter/setter 方法，
 通过这些 API 可以使你不需要了解这个规则（但你最好还是要搞清楚），
 这些 API 存放于包 java.beans 中。


 一般的做法是通过类 Introspector 来获取某个对象的 BeanInfo 信息，
 然后通过 BeanInfo 来获取属性的描述器（ PropertyDescriptor ），
 通过这个属性描述器就可以获取某个属性对应的 getter/setter 方法，
 然后我们就可以通过反射机制来调用这些方法。
 下面我们来看一个例子，这个例子把某个对象的所有属性名称和值都打印出来：
 */
public class IntrospectorDemo {

    String name;
    public static void main(String[] args) throws Exception{
        IntrospectorDemo demo = new IntrospectorDemo();
        demo.setName( "Winter Lau" );

        // 如果不想把父类的属性也列出来的话，
        // 那 getBeanInfo 的第二个参数填写父类的信息
        BeanInfo bi = Introspector.getBeanInfo(demo.getClass(), Object.class );
        PropertyDescriptor[] props = bi.getPropertyDescriptors();
        for ( int i=0;i<props.length;i++){
            System.out.println(props[i].getName()+ "=" +
                    props[i].getReadMethod().invoke(demo, null ));
        }

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this .name = name;
    }

}
