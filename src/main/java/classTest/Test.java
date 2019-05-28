package classTest;

/**
 * @Package Name : ${PACKAG_NAME}
 * @Creation Date : 2019年03月22日下午2:15
 * @Function : todo
 */

public class Test {
    static {
        Name mName;
        System.out.println("Test Class loaded");
    }

    public  static void main(String[] args) {
        System.out.println("entern Test main()");

        // Name.class
        Class mClassPointClass;
        // Class.forName("完整包名+类名")
        Class mClassForName;
        // new 对象后，对象.getClass()
        Class mClassObjectPointClass1;
        Class mClassObjectPointClass2;

        try {
            //测试 类名.class
            mClassPointClass = Name.class;
            System.out.println("mClassPointClass = " + mClassPointClass);

            //测试Class.forName()
            mClassForName = Class.forName("classTest.Name");
            System.out.println("mClassForName = " + mClassForName);

            //测试Object.getClass()
            Name name1 = new Name();
            mClassObjectPointClass1 = name1.getClass();
            System.out.println("mClassObjectPointClass1 = " + mClassObjectPointClass1);
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return;
        }

        Name name2;
        System.out.println("defined one Name object");
        name2 = new Name();
        System.out.println("Name object instance done!");

        mClassObjectPointClass2 = name2.getClass();

        if (mClassForName == mClassPointClass
                && mClassPointClass == mClassObjectPointClass1
                && mClassObjectPointClass1 == mClassObjectPointClass2) {
            System.out.println("all the Class object equal...");
        }
    }
}