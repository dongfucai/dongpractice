package random;

import java.util.Random;

/**
 * @Package Name : ${PACKAG_NAME}
 * @Author : dongfucai@meituan.com
 * @Creation Date : 2018年06月05日上午10:36
 * @Function : todo
 */
public class RandomTest {

    /*
      java.util.Random
      Random()  以当前时间System.currentTimeMillis（） 为发生器
      Random(long seed)   以 seed 为发生器的种子
      随机数发生器(Random)对象产生以后，通过调用不同的method：nextInt()、nextLong()、nextFloat()、nextDouble()等获得不同类型随机数。

     */

    private StringBuffer stringBuffer = new StringBuffer("/data/applogs/csc-pacific-task-service/");

    public static void main(String[] args) {

        //如果2个不同的bRandom对象使用相同的种子（比如都是100），
        // 并且以相同的顺序调用相同的函数，那它们返回值完全相同。如下面代码中两个Random对象的输出完全相同

        Random random1 = new Random(100);
        System.out.println(random1.nextInt());
        System.out.println(random1.nextFloat());
        System.out.println(random1.nextBoolean());

        Random random2 = new Random(100);
        System.out.println(random2.nextInt());
        System.out.println(random2.nextFloat());
        System.out.println(random2.nextBoolean());



        // 2 指定范围内的随机数
        //   获得的随机数有正有负的，用Math.abs使获取数据范围为非负数
        Random random = new Random();
        for (int i=0;i<10;++i){
            System.out.println(Math.abs(random.nextInt()%10)+"dgeg");

            System.out.println(Math.abs(random.nextInt())+"dgeg");
        }

        String str ="/data/";
        for (int i=0;i<10;++i){
            //System.out.println(Math.abs(random.nextInt()%10)+"dgeg");

            System.out.println(str+Math.abs(random.nextInt()));
        }


        StringBuffer fileDirctory = new StringBuffer("sfsssssssss/");

        for (int i=0;i<100;++i) {

            Random random12 = new Random();
            String localFilePath = fileDirctory.append(Math.abs(random12.nextInt() % 1000000000)).toString();
            System.out.println(localFilePath);
            //
        }



        StringBuilder sb = new StringBuilder("1111");
        sb.append("34353");
        sb.append("sdfsfs");
        System.out.println(sb.toString());


    }

}
