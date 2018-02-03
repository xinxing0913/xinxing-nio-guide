package com.mengzhidu.nio.demo;

import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 如果我们一次读不完，那么该怎么办呢
 * 我们可以读取多次，然后
 */
public class Demo2 {
    public static void main(String[] args) throws Exception{
        String path = "src/main/resources/demo02.txt";
        FileInputStream inputStream = new FileInputStream(path);
        // 获取指定文件的通道
        FileChannel inputChannel = inputStream.getChannel();

        // 我们申请的缓冲区尽量小一些
        ByteBuffer byteBuffer = ByteBuffer.allocate(32);

        while (true) {
            // 从通道中读取数据
            int n =  inputChannel.read(byteBuffer);
            // 读取结束，直接跳出
            if (n == -1) {
                break;
            }
            // 重置位置
            byteBuffer.clear();

            // 输出获取到的数据内容
            byte[] bytes = byteBuffer.array();
            System.out.println("读取的长度:" + n + " 内容:" + new String(bytes, 0, n ));
        }

    }
}
