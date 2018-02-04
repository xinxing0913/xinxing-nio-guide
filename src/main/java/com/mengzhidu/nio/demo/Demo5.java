package com.mengzhidu.nio.demo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 这里我们是在一个循环中依次对文件进行读写操作
 * 当然我们获取FileChannel也可以使用其他方式，比如RandAccessFile类来获取
 * 下面就是我们对应的代码范例:
 * FileChannel readChannel = new RandomAccessFile(readPath, "r").getChannel();
 * FileChannel writeChannel = new RandomAccessFile(readPath, "rw").getChannel();
 */
public class Demo5 {
    public static void main(String[] args) throws Exception{
        String readPath = "src/main/resources/demo04.txt";
        String writePath = "src/main/resources/demo05.txt";

        // 获取指定文件的通道
        FileChannel readChannel = new FileInputStream(readPath).getChannel();
        FileChannel writeChannel = new FileOutputStream(writePath).getChannel();

        // 我们申请的缓冲区尽量小一些
        ByteBuffer byteBuffer = ByteBuffer.allocate(32);

        while (true) {
            // 清空数据并且读取数据
            byteBuffer.clear();
            int n =  readChannel.read(byteBuffer);
            System.out.println("n的值:" + n);
            // 读取结束，直接跳出
            if (n <= 0) {
                break;
            }

            // 进行反转，把limit设置为position，把position置为0，把mark置为-1
            byteBuffer.flip();
            // 把数据从缓冲区写入通道
            writeChannel.write(byteBuffer);
        }

        System.out.println("操作完成");

        // 关闭读写通道
        readChannel.close();
        writeChannel.close();
    }
}
