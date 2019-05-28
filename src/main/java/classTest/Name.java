package classTest;

/**
 * @Package Name : ${PACKAG_NAME}
 * @Creation Date : 2019年03月22日下午2:14
 * @Function : todo
 */

public class Name {
    static int count = 0;
    static {
        count++;
        System.out.println("Name Class Loaded! count = [" + count + "]" );
    }

    public Name() {
        System.out.println("Name Constructor called!");
    }

}