package com.wzy.nio;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * @author cherish_vf
 * @date 2023/03/23
 */
public class NIOClient1 {
    public static void main(String[] args) {
        try {
            SocketChannel socketChannel = SocketChannel.open();
            socketChannel.configureBlocking(false);
            InetSocketAddress localhost = new InetSocketAddress("localhost", 7777);

            if (!socketChannel.connect(localhost)) {
                while (!socketChannel.finishConnect()) {
                    System.out.println(">>>通道正在连接...");
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(">>>通道建立完成");
            }
            System.out.println(">>>客户端1连接完成");

            ByteBuffer byteBuffer = ByteBuffer.wrap("我是客户端一号...".getBytes());
            socketChannel.write(byteBuffer);
            //Thread.sleep( 2000000 );
            socketChannel.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
