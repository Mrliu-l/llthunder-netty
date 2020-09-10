package com.llthunder.netty.nio.buffer;

import java.nio.IntBuffer;

/**
 * 缓冲区分片
 */
public class BufferSliceDemo {

    public static void main(String[] args) {
        IntBuffer intBuffer = IntBuffer.allocate(10);
        //给缓冲区的数据复制：1-10
        for(int i = 1; i <= intBuffer.capacity(); i++){
            intBuffer.put(i);
        }
        //分片：创建子缓冲区
        intBuffer.position(3);
        intBuffer.limit(7);
        IntBuffer slice = intBuffer.slice();
        //给子缓冲区中的数据*10
        for (int i = 0; i < slice.capacity(); i++){
            int value = slice.get(i);
            slice.put(i, value  * 10);
        }
        //重置主buffer的状态位
        intBuffer.position(0);
        intBuffer.limit(intBuffer.capacity());
        //读取buffer中的数据
        while (intBuffer.hasRemaining()){
            System.out.print(intBuffer.get() + "    ");
        }
    }
}
