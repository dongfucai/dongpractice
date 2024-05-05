package algorithm.kaoshi;

import java.util.*;

/**
 * @Author dongfucai/1766318593@qq.com
 * @Description //TODO
 * @Date 2021/4/21 下午6:19
 * @Version 1.0
 **/

public class Test2 {


    public class Node {
        int val;
        ArrayList<Node> child;

        public int getValue() {
            return val;
        }

        void printVal() {
            System.out.println(val);
        }
    }

    public static void levelPrint(Node node) {
        if (node == null) {
            return;
        }
        Queue<Node> nodeQueue = new LinkedList();
        nodeQueue.add(node);

        while (!nodeQueue.isEmpty()) {

            Node temp = ((LinkedList<Node>) nodeQueue).getFirst();


        }

    }

    public void levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return ;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int count = queue.size();
            //外层循环为一层
            //List<Integer> list = new ArrayList<>();
            while (count-- > 0) {
                //将当前元素的非空子节点压入栈
                Node cur = queue.poll();
                // 打印
                cur.printVal();
                for (Node node : cur.child) {
                    if (node != null) {
                        queue.add(node);
                    }
                }
            }
            //res.add(list);
        }
        return ;
    }


    public static void main(String[] args) {


    }


}
