package com.wzy.concurrent.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * NIO聊天室server端
 *
 * @author wzy
 * @date 2023-03-29 21:28:51
 */
@SuppressWarnings("all")
public class NioChatServer {
    public static void main(String[] args) throws IOException {
        // 创建ServerChannel
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        InetSocketAddress inetSocketAddress = new InetSocketAddress(7778);
        // 绑定监听端口
        serverSocketChannel.bind(inetSocketAddress);
        // 创建Selector对象
        Selector selector = Selector.open();
        // 设置ServerChannel非阻塞
        serverSocketChannel.configureBlocking(false);
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        // 循环监听
        while (true) {
            // 重新拉取是否有准备就绪的channel，其实SelectionKey可以理解为Channel的指针，属于映射关系
            selector.select();
            // 获取所有就绪的channel
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            Iterator<SelectionKey> selectionKeyIterator = selectionKeys.iterator();

            // 循环判断就绪的channel要触发接受连接事件、读事件、写事件
            while (selectionKeyIterator.hasNext()) {
                SelectionKey selectionKey = selectionKeyIterator.next();
                selectionKeyIterator.remove();

                if (selectionKey.isAcceptable()) {
                    doAccept(selector, selectionKey);
                } else if (selectionKey.isReadable()) {
                    doRead(selectionKey);
                } else if (selectionKey.isWritable()) {
                    doWriteable(selectionKey);
                }
            }
        }
    }

    /**
     * 写入方法
     */
    private static void doWriteable(SelectionKey selectionKey) throws IOException {
        SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
        ByteBuffer byteBuffer = (ByteBuffer) selectionKey.attachment();

        if (byteBuffer.hasRemaining()) {
            System.out.println("===输出给客户端的信息：" + new String(byteBuffer.array()).trim());
            socketChannel.write(byteBuffer);
        } else {
            socketChannel.close();
        }
    }

    /**
     * 读取方法
     */
    private static void doRead(SelectionKey selectionKey) throws IOException {
        SocketChannel channel = (SocketChannel) selectionKey.channel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        int read;
        do {
            read = channel.read(byteBuffer);
            byteBuffer.clear();
            if (read > 0) {
                System.out.println("===接收到数据:" + new String(byteBuffer.array()).trim());
            }
        } while (read > 0);
        // 如果只是读取不执行写操作了，直接可以关闭通道了
//        channel.close();
        // 切换这个channel为可读模式
        selectionKey.interestOps(SelectionKey.OP_WRITE);
        String responseContent = "服务端向你发出闪电五连鞭！";
        ByteBuffer responseByteBuffer = ByteBuffer.wrap(responseContent.getBytes());
        selectionKey.attach(responseByteBuffer);
    }

    /**
     * 接收请求
     */
    private static void doAccept(Selector selector, SelectionKey selectionKey) throws IOException {
        ServerSocketChannel serverSocketChannel = (ServerSocketChannel) selectionKey.channel();
        // 接收请求
        SocketChannel socketChannel = serverSocketChannel.accept();
        socketChannel.configureBlocking(false);
        System.out.println("===与客户端建立连接===");
        // 将客户端的channel注册到selecotr，设置通道接受读取模式
        socketChannel.register(selector, SelectionKey.OP_READ);
    }
}
