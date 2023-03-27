package com.wzy.socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author wzy
 * @version 1.0
 * @date 2022/7/16 2:50 下午
 */
public class SocketServer {

    @SuppressWarnings("all")
    public static void main(String[] args) throws IOException {
        int port = 8888;
        ServerSocket serverSocket = new ServerSocket(port);

        while (true) {
            Socket socket = serverSocket.accept();

            DataInputStream in = new DataInputStream(socket.getInputStream());

            String inputString = in.readUTF();
            System.out.println(inputString);

            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            out.writeUTF(String.format("你传递的信息是：%s，服务端计算它的长度为：%s", inputString, inputString.length()));
            out.flush();
            socket.close();
        }
    }
}