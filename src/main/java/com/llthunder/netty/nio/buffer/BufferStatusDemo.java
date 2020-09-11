package com.llthunder.netty.nio.buffer;

import java.io.*;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * buffer基本示例:演示position/limit/capacity的变化
 */
public class BufferStatusDemo {

    public static void main(String[] args) throws IOException {
        //读取文件流，此处操作时I/O操作
        String fileUrl = BufferStatusDemo.class.getClassLoader().getResource("BufferDemoText.text").getFile();
        FileInputStream inputStream = new FileInputStream(fileUrl);
        FileChannel inputChannel = inputStream.getChannel();
        //创建一个大小为10的缓冲区
        ByteBuffer byteBuffer = ByteBuffer.allocate(100);
        out("初始化", byteBuffer);
        //将数据写入缓冲区
        inputChannel.read(byteBuffer);
        out("调用read", byteBuffer);
        //锁定写入范围
        byteBuffer.flip();
        out("调用flip", byteBuffer);
        while (byteBuffer.hasRemaining()){
            byte b = byteBuffer.get();
        }
        //可以理解对flip的解锁
        byteBuffer.clear();
        out("调用clear", byteBuffer);
        //关闭流
        inputStream.close();
    }

    public static void out(String step, Buffer buffer){
        System.out.println(step + ":");
        System.out.print("position:" + buffer.position() + ",");
        System.out.print("limit:" + buffer.limit() + ",");
        System.out.print("capacity:" + buffer.capacity() + ",");
        System.out.println();System.out.println();
    }
}
