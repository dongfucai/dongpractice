package random.test.deal;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author dongfucai/1766318593@qq.com
 * @Description //TODO
 * @Date 2020/11/12 上午11:06
 * @Version 1.0
 **/

public class MergeHandler {

    public static List merge(List<Integer> list1, List<Integer> list2) {
         List ret = Lists.newArrayList();

        int i = 0, j = 0, m = list1.size(), n = list2.size();

        while(i < m && j < n) {

            if(list1.get(i).compareTo(list2.get(j)) < 0) {
                ret.add(list1.get(i++));

            } else {
                ret.add(list2.get(j++));

            }

        }

        while(i < m) {
            ret.add(list1.get(i++));
        }

        while(j < n) {
            ret.add(list2.get(j++));
        }

        return ret;
    }

    static public  void mergeHandle(List<List> data) {

        List result = Lists.newArrayList();
        for (List list : data) {

            result = MergeHandler.merge(result, list);
        }
        System.out.println(result.stream().map(String::valueOf).collect(Collectors.joining(", ")));

    }

    public static void main(String[] args) {

        mergeHandle(TreadSortHandler.threadHandle());

    }

}
