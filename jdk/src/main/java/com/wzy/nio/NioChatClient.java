package com.wzy.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * NIO聊天室server端
 *
 * @author wzy
 * @date 2023-03-29 21:28:51
 */
@SuppressWarnings("all")
public class NioChatClient {
    public static void main(String[] args) throws IOException, InterruptedException {
        SocketChannel socketChannel = SocketChannel.open();
        InetSocketAddress inetSocketAddress = new InetSocketAddress("localhost", 7778);

        if (!socketChannel.connect(inetSocketAddress)) {
            while (!socketChannel.finishConnect()) {
                System.out.println("===通道正在连接===");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("===通道连接完成===");
        }
        
        ByteBuffer byteBuffer = ByteBuffer.wrap("你好，我是马保国".getBytes());
        socketChannel.write(byteBuffer);

        ByteBuffer responseBuffer = ByteBuffer.allocate(1024);
        socketChannel.read(responseBuffer);
        System.out.println("===接收到数据:" + new String(responseBuffer.array()).trim());

        Thread.sleep(1000);
    }
}
