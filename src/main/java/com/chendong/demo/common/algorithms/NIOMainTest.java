package com.chendong.demo.common.algorithms;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NIOMainTest {

    public static void main(String[] args) throws IOException {

        fastCopy("D:\\111.docx", "D:\\Desktop\\2.docx");
    }


    public static void fastCopy(String src, String dest) throws IOException {
        try (
                //获取源文件和目标文件的输入和输出流
                FileInputStream fileInput = new FileInputStream(src);
                FileOutputStream fileOutput = new FileOutputStream(dest)
        ) {

            //输入流的通道
            FileChannel inChannel = fileInput.getChannel();
            //输出流的通道
            FileChannel outChannel = fileOutput.getChannel();
            //缓冲区
            ByteBuffer byteBuffer = ByteBuffer.allocateDirect(1024);

            while (true) {
                //从输入流中读取数据到缓冲区
                int read = inChannel.read(byteBuffer);
                if (read == -1) {
                    break;
                }

                //切换读写
                byteBuffer.flip();

                //把缓冲区的内容写入输出文件
                outChannel.write(byteBuffer);

                //清空缓冲区
                byteBuffer.clear();
            }

        }
    }
}
