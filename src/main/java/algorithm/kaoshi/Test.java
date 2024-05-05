package algorithm.kaoshi;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * @Author dongfucai/1766318593@qq.com
 * @Description //TODO
 * @Date 2021/4/21 下午5:57
 * @Version 1.0
 **/

public class Test {


    public class Node {
        int value;
        Node next;

        public int getValue() {
            return value;
        }

        void printVal() {
            System.out.println(value);

        }

    }

    public static Node merge(Node a, Node b) {
        if(a == null) {
            return b;
        } else if (b == null) {
            return a;
        }
        Node realHead;
        if(a.value < b.value) {
            realHead = a;
            a.next = merge(a.next, b);
        } else {
            realHead = b;
            b.next = merge(a, b.next);
        }

        return realHead;

    }


    public class Point2D {
        double X;
        double Y;

        public double getY() {
            return Y;
        }

        public double getX() {
            return X;
        }

        public double distance() {
            return 22.22;
        }
    }



    public static void main(String[] args) {


        List<Point2D> point2DList = Lists.newArrayList();

        long count = point2DList.stream().filter(m -> m.getY() > 1).count();

        double  distance  = point2DList.stream().filter(m -> m.getY() > 1).mapToDouble(Point2D::distance).sum();



        System.out.println("sdsdsd");

        return;
    }
}
