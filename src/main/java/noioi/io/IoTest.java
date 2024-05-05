package noioi.io;

import java.io.*;

/**
 * @Author dongfucai/1766318593@qq.com
 * @Description //TODO
 * @Date 2021/4/7 下午5:25
 * @Version 1.0
 **/

public class IoTest {



    public static void main(String[] args) throws FileNotFoundException,
            IOException {
        writFileTest();

        readFileTest();
    }

    private static void writFileTest() throws FileNotFoundException,
            IOException {
        // 创建文件对象
        File file = new File("a.txt");
        // 创建文件输出流
        //FileOutputStream fos = new FileOutputStream(file);
        FileOutputStream fos = new FileOutputStream(file);

        fos.write('3');
        fos.write('g');
        fos.write('z');
        fos.write('i');
        fos.write('t');
        fos.write('c');
        fos.write('a');
        fos.write('s');
        fos.write('t');

        fos.close();


    }

    private static void readFileTest() throws FileNotFoundException,
            IOException {
        // 创建文件对象
        File file = new File("a.txt");
        // 创建文件输入流
        FileInputStream fis = new FileInputStream(file);
        // 有对多长，就读多少字节。
        for (int i = 0; i < file.length(); i++) {
            System.out.print((char) fis.read());
        }
        fis.close();
    }

}
