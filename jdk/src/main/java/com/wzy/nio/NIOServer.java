package com.wzy.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @author cherish_vf
 * @date 2023/03/23
 */
public class NIOServer {
    public static void main1(String[] args) {
        try {
            //创建一个通道
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            InetSocketAddress inetSocketAddress = new InetSocketAddress(7777);
            //绑定监听端口
            serverSocketChannel.bind(inetSocketAddress);
            //通道设置为非阻塞
            serverSocketChannel.configureBlocking(false);

            //开启selector,并将channel注册到selector上
            Selector selector = Selector.open();
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

            while (true) {
                int select = selector.select();
                Set<SelectionKey> selectionKeys = selector.selectedKeys();

                //遍历selectionKeys
                Iterator<SelectionKey> iterator = selectionKeys.iterator();
                while (iterator.hasNext()) {
                    SelectionKey nextKey = iterator.next();
                    iterator.remove();
                    Thread.sleep(1000);
                    if (!nextKey.isValid()) {
                        continue;
                    }
                    //当前事件处理完需要移除
                    if (nextKey.isAcceptable()) {
                        //连接请求
                        SocketChannel socket = serverSocketChannel.accept();
                        socket.configureBlocking(false);
                        System.out.println(">>>client is connected");
                        socket.register(selector, SelectionKey.OP_READ);
                    } else if (nextKey.isReadable()) {
                        //TODO 进行测试时,需要留意,如果客户端发起连接后断开, 则客户端发送默认读事件,服务端需要对连接进行关闭
                        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
                        //这个事件执行完好像自动移除了,所以下面这个代码执不执行都无所谓

                        //这个channel是serverSocketChannel还是socketChannel取决于注册时填的channel
                        //默认返回的channel类型是父类型,需要强转指定类型
                        SocketChannel channel = (SocketChannel) nextKey.channel();
                        //将通道中,读出来的数据,写到缓冲区
                        int read = channel.read(byteBuffer);
                        if (read > 0) {
                            String s = new String(byteBuffer.array()).trim();
                            System.out.println(">>>接收到数据:" + s);
                        } else {
                            System.out.println("客户端关闭");
                            //关闭通道
//                            channel.close();
                        }
                    }

                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Set<String> set = new HashSet<>();

        set.add("1");
        set.add("2");
        set.add("3");

        Iterator<String> iterator = set.iterator();

        while (iterator.hasNext()) {
            iterator.next();
            iterator.remove();
        }

        System.out.println(set.size());

    }
}
