package com.chendong.demo.common.algorithms;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class NIOServer {

    public static void main(String[] args) throws IOException {

        try (
                //创建选择器
                Selector selector = Selector.open();
                ServerSocketChannel ssChannel = ServerSocketChannel.open();
        ) {
            //将通道注册到选择器上
            ssChannel.configureBlocking(false);//配置通道是否是阻塞
            ssChannel.register(selector, SelectionKey.OP_ACCEPT);
            ssChannel.socket().bind(new InetSocketAddress("127.0.0.1", 8888));


            //因为一次 select() 调用不能处理完所有的事件，并且服务器端有可能需要一直监听事件，
            //因此服务器端处理事件的代码一般会放在一个死循环内。
            while (true) {

                //监听到达的事件
                selector.select();
                //使用 select() 来监听到达的事件，它会一直阻塞直到有至少一个事件到达。
                Set<SelectionKey> keys = selector.selectedKeys();
                Iterator<SelectionKey> keyIterator = keys.iterator();

                while (keyIterator.hasNext()) {

                    SelectionKey key = keyIterator.next();

                    if (key.isAcceptable()) {

                        ServerSocketChannel ssChannel1 = (ServerSocketChannel) key.channel();

                        // 服务器会为每个新连接创建一个 SocketChannel
                        SocketChannel sChannel = ssChannel1.accept();
                        sChannel.configureBlocking(false);

                        // 这个新连接主要用于从客户端读取数据
                        sChannel.register(selector, SelectionKey.OP_READ);

                    } else if (key.isReadable()) {

                        SocketChannel sChannel = (SocketChannel) key.channel();
                        System.out.println(readDataFromSocketChannel(sChannel));
                        sChannel.close();
                    }

                    keyIterator.remove();
                }
            }
        }
    }

    private static String readDataFromSocketChannel(SocketChannel sChannel) throws IOException {

        ByteBuffer buffer = ByteBuffer.allocate(1024);
        StringBuilder data = new StringBuilder();

        while (true) {

            buffer.clear();
            int n = sChannel.read(buffer);
            if (n == -1) {
                break;
            }
            buffer.flip();
            int limit = buffer.limit();
            char[] dst = new char[limit];
            for (int i = 0; i < limit; i++) {
                dst[i] = (char) buffer.get(i);
            }
            data.append(dst);
            buffer.clear();
        }
        return data.toString();
    }
}
