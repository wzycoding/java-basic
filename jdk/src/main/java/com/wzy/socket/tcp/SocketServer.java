package com.wzy.socket.tcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author wzy
 */
public class SocketServer {

    @SuppressWarnings("all")
    public static void main(String[] args) throws IOException {
        ServerSocket welcomeSocket = new ServerSocket(8090);
        while (true) {
            Socket connectSocket = welcomeSocket.accept();
            InputStream inputStream = connectSocket.getInputStream();

            DataInputStream in = new DataInputStream(inputStream);

            String inputString = in.readUTF();

            System.out.println("客户端发过来的信息：" + inputString);

            DataOutputStream out = new DataOutputStream(connectSocket.getOutputStream());
            String returnMsg = inputString.toUpperCase();
            System.out.println("发回给客户端信息内容：" + returnMsg);
            out.writeUTF(returnMsg);
            out.flush();
            out.close();

            connectSocket.close();
        }
    }
}
