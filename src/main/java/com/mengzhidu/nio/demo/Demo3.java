package com.mengzhidu.nio.demo;

import java.nio.ByteBuffer;

/**
 * 我们可以不通过读文件的方式来获取ByteBuffer
 * 我们可以直接从字节数组中获取
 * 然后有对ByteBuffer的一些简单操作
 */
public class Demo3 {
    public static void main(String[] args) {
        byte[] bytes = "hello xinxing".getBytes();

        // 直接包装一个字节数组来得到ByteBuffer
        ByteBuffer buffer = ByteBuffer.wrap(bytes);

        // 打印该buffer的初始信息
        System.out.println("初始缓冲区的capcity:" + buffer.capacity());
        System.out.println("初始缓冲区的limit:" + buffer.limit());
        System.out.println("初始缓冲区的position:" + buffer.position());
        System.out.println();

        // 取出特定位置的字节
        byte b = buffer.get(2);
        System.out.println("第3个字符为:" + (char)b);
        System.out.println();

        // 我们可以修改单个字节的内容
        buffer.put(9, (byte)'s');
        buffer.put(10, (byte)'t');
        buffer.put(11, (byte)'a');
        buffer.put(12, (byte)'r');
        System.out.println("修改后的缓冲区内容为:" + new String(buffer.array()));
        System.out.println();

        // 这里position为0，我们覆盖前面一部分内容
        buffer.put("oooo".getBytes());
        System.out.println("覆盖后的内容为:" + new String(buffer.array()));
        System.out.println();

        // 设置新的position后，我们覆盖后面一部分内容
        buffer.position(6);
        buffer.put("xxxxxx".getBytes());
        System.out.println("二次覆盖后的内容为:" + new String(buffer.array()));
        System.out.println();

        // 输出前七个字符
        buffer.position(0);
        buffer.limit(7);
        while (buffer.hasRemaining()) {
            System.out.println("字符有:" + (char)buffer.get());
        }
    }
}
