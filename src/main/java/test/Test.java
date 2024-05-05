package test;

/**
 * @Author dongfucai/1766318593@qq.com
 * @Description //TODO
 * @Date 2023/6/30 下午1:38
 * @Version 1.0
 **/

public class Test {

    public static void main(String[] args) {


        String str = "erkkty123qqquizzzzzo";
        String str1 = str.replaceAll("(.)\\1+", "$1");
        System.out.println(str1);



    }
}
