package noioi;

import java.nio.IntBuffer;

/**
 * @Package Name : ${PACKAG_NAME}
 * @Author : dongfucai@meituan.com
 * @Creation Date : 2018年05月14日下午2:40
 * @Function : todo
 */
public class TestIntBuffer {

    public static void main(String[] args) {

        // 分配int 缓冲区， 参数为 缓冲区容量
        //  // 新缓冲区的当前位置将为零，其界限(限制位置)将为其容量。它将具有一个底层实现数组，其数组偏移量将为零。

        IntBuffer intBuffer = IntBuffer.allocate(8);

        System.out.println(intBuffer.capacity()+"   ");
        for(int i=0;i<intBuffer.capacity()-2;++i){
            int  j= 2 *(i+1);
            // 将给定整数写入此缓冲区的当前位置，当前位置递增
            intBuffer.put(j);
        }

        // 重设缓冲区  ， 将限制设为当前位置， 然后将当前位置设为0
        intBuffer.flip();

        // 查看在当前位置和限制位置之间是否有元素
        while (intBuffer.hasRemaining()){
            // 读取此缓冲区当位置的整数，然后当前位置递增
            int j=intBuffer.get();
            System.out.println(j+" ");
        }

    }

}
