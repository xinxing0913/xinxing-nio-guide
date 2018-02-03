package com.mengzhidu.nio.demo;

import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 文件读写是我们最熟悉的一个操作
 * 我们这里就使用nio的方式来对一个文件进行读操作
 * 我们读的文件内容是resources目录下的demo01.txt
 */
public class Demo1 {
    public static void main(String[] args) throws Exception {
        String path = "src/main/resources/demo01.txt";
        FileInputStream inputStream = new FileInputStream(path);
        // 得到特定文件的通道
        FileChannel fileChannel = inputStream.getChannel();
        // 申请100个字节大小的字节缓存区
        ByteBuffer buffer = ByteBuffer.allocate(100);
        // 读取文件内容
        fileChannel.read(buffer);
        // 拿到暂存区中的数据内容
        System.out.println("读取的内容: " + new String(buffer.array()));
        // 关闭通道
        fileChannel.close();
    }
}
