package noioi;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @Package Name : ${PACKAG_NAME}
 * @Author : 1766318593@qq.com
 * @Creation Date : 2018年05月14日上午11:54
 * @Function : todo
 */
public class InputNIOChannel {

    public static void main(String[] args) throws IOException {
        // 创建一个File实例
        File file =new File("/Users/dongfucai/dongpractice/IOtext.txt");

        // FileInputStream 为文件输入流
        FileInputStream in = new FileInputStream(file);


        // 缓冲器向通道输入数据
        FileChannel fileChannel = in.getChannel();

        // 创建一个2014 的buffer
        ByteBuffer buf =ByteBuffer.allocate(1024);

        // 写入数据到Buffer
        int bytesRead = fileChannel.read(buf);

        while(bytesRead != -1){
            // 回绕缓冲区//回绕缓冲区（输出通道会从数据的开头而不是末尾开始）
            buf.flip();
            while (buf.hasRemaining()){
                System.out.println((char)buf.get());
            }


            /**
             * 压缩此缓冲区，compact 方法会执行两个动作
             * 1 清除之前写好的字符
             * 2 通过表记的位置为0
             * 这就是为什么要结合filp（） 使用
             *
             */
            buf.compact();

            // 写入数据到buufer
            bytesRead = fileChannel.read(buf);
        }


    }

}
