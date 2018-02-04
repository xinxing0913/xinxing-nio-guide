package com.mengzhidu.nio.demo;

import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 以ByteBuffer为例
 * 探究一下Buffer类的一些具体操作
 */
public class Demo2 {
    public static void main(String[] args) throws Exception{
        String path = "src/main/resources/demo02.txt";
        // 得到特定文件的通道
        FileChannel fileChannel = new FileInputStream(path).getChannel();
        // 申请100个字节大小的字节缓存区
        ByteBuffer buffer = ByteBuffer.allocate(100);
        System.out.println("在读取数据前缓冲区的capcity:" + buffer.capacity());
        System.out.println("在读取数据前缓冲区的limit:" + buffer.limit());
        System.out.println("在读取数据前缓冲区的position:" + buffer.position());
        System.out.println();
        // 读取文件内容
        int length = fileChannel.read(buffer);
        System.out.println("在读取数据后缓冲区的capcity:" + buffer.capacity());
        System.out.println("在读取数据后缓冲区的limit:" + buffer.limit());
        System.out.println("在读取数据后缓冲区的position:" + buffer.position());
        System.out.println();

        // 读取的数据内容
        System.out.println("读取的长度:" + length);
        System.out.println("读取的内容: " + new String(buffer.array()));
        System.out.println();

        // 清空数据
        buffer.clear();
        System.out.println("在清空数据后缓冲区的capcity:" + buffer.capacity());
        System.out.println("在清空数据后缓冲区的limit:" + buffer.limit());
        System.out.println("在清空数据后缓冲区的position:" + buffer.position());
        System.out.println();

        // 需要说明的是
        // 这里的数据并没有被释放
        System.out.println("在clear后数据是:" + new String(buffer.array()));

        // 关闭通道
        fileChannel.close();
    }
}
