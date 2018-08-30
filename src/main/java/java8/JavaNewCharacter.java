package java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Package Name : ${PACKAG_NAME}
 * @Author : 1766318593@qq.com
 * @Creation Date : 2018年06月12日下午3:33
 * @Function : todo
 */
public class JavaNewCharacter {

    public static void main(String[] args) {

        String [] array = {"a","b","c"};
        List<String> strings = Arrays.asList(array);
        List<String> output=strings.stream().map(String::toUpperCase).collect(Collectors.toList());
        System.out.println(output);


        List<Integer> nums=Arrays.asList(1,2,3,4);
        List<Integer> squaresNums=nums.stream().map(n -> n*n).collect(Collectors.toList());
        System.out.println(squaresNums);

        Integer [] sixNums ={1,2,3,4,5};
        Integer [] evens = Stream.of(sixNums).filter(n -> n%2 == 0).toArray(Integer[]::new);

        System.out.println(Arrays.toString(evens));
        for(int i=0;i<evens.length;++i){
            System.out.println(evens[i]);
        }





    }

}
