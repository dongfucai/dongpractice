package product_consumer;

/**
 * @Package Name : ${PACKAG_NAME}
 * @Author : 1766318593@qq.com
 * @Creation Date : 2018年12月09日下午1:59
 * @Function : todo
 */
public class Meal {
    private final int orderNum;

    public Meal(int orderNum) {
        this.orderNum = orderNum;
    }

    @Override
    public String toString() {
        return "Meal " + orderNum;
    }
}
