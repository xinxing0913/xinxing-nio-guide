package com.mengzhidu.x001;

import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 文件读写是我们最熟悉的一个操作
 * 我们这里就使用nio的方式来对一个文件进行读操作
 */
public class App {
    public static void main(String[] args) throws Exception {
        String path = "src/main/resources/demo1.txt";
        FileInputStream inputStream = new FileInputStream(path);
        FileChannel fileChannel = inputStream.getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(100);
        fileChannel.read(buffer);
        System.out.println("读取的内容: " + new String(buffer.array()));
    }
}
