package com.llthunder.netty.nio.buffer;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 内存映射：直接操作磁盘文件的buffer示例
 */
public class MappedBufferDemo {

    public static void main(String[] args) throws IOException {
        String file = MappedBufferDemo.class.getClassLoader().getResource("BufferDemoText.text").getFile();
        //RandomAccessFile可以自由访问文件的任意位置
        RandomAccessFile raf = new RandomAccessFile(file, "rw");
        FileChannel channel = raf.getChannel();
        //把缓冲区与文件进行一个映射关联
        //只要操作内存中的数据，文件中的内容也会发生变化
        MappedByteBuffer mbBuffer = channel.map(FileChannel.MapMode.READ_WRITE, 0, 1024);
        mbBuffer.put("   |   测试内存映射buffer".getBytes());
        ByteBuffer put = mbBuffer.put(0, (byte)97);
        mbBuffer.put(1023, (byte)122);
        raf.close();
    }
}
