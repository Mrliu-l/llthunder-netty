package com.llthunder.netty.nio.buffer;

import java.nio.IntBuffer;

public class IntbufferDemo {

    public static void main(String[] args) {
        //buffer中共有3个属性
        //  position：下一个要被操作的数组索引；
        //  limit：代表还有多少索引需要输出
        //  capacity：代表buffer的总大小，也可以理解为数组的总大小
        IntBuffer intBuffer = IntBuffer.allocate(8);
        for(int i = 0; i < intBuffer.capacity(); i++){
            int j = 2 * (i + 1);
            intBuffer.put(j);
        }
        //重设此缓冲区，将limit设置到position位置上,position设置到0
        intBuffer.flip();
        //读取position到limit的数据
        while (intBuffer.hasRemaining()){
            //读取缓冲区当前position位置的数据，知道position=limit
            int j = intBuffer.get();
            System.out.println(j);
        }
    }
}
