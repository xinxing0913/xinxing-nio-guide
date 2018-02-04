package com.mengzhidu.nio.demo;

import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 对文件的循环读取
 * 这里我们选择了一个相对大一点的文本文档
 * 我们的缓冲区尽量小一些
 * 在我们的缓冲区需要使用多次，不要忘记调整position的位置
 */
public class Demo4 {
    public static void main(String[] args) throws Exception{
        String path = "src/main/resources/demo04.txt";
        FileInputStream inputStream = new FileInputStream(path);
        // 获取指定文件的通道
        FileChannel inputChannel = inputStream.getChannel();
        // 我们申请的缓冲区尽量小一些
        ByteBuffer byteBuffer = ByteBuffer.allocate(32);

        while (true) {
            // 重置position
            byteBuffer.clear();
            // 从通道中读取数据
            int n =  inputChannel.read(byteBuffer);
            // 读取结束，直接跳出
            if (n == -1) {
                break;
            }

            // 输出获取到的数据内容
            byte[] bytes = byteBuffer.array();
            System.out.println("读取的长度:" + n + " 内容:" + new String(bytes, 0, n ));
        }

        // 不要忘记关闭通道
        inputChannel.close();
    }
}
