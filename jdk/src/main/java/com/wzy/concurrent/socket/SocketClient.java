package com.wzy.concurrent.socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author wzy
 * @version 1.0
 * @date 2022/7/16 2:50 下午
 */
public class SocketClient {

    public static void main(String[] args) throws IOException {
        String serverName = "localhost";
        int port = 8888;


        while (true) {
            Socket socketClient = new Socket(serverName, port);
            System.out.print("请输入要发送的数据：");
            Scanner scanner = new Scanner(System.in);

            String inputString = scanner.nextLine();
            DataOutputStream dataOutputStream = new DataOutputStream(socketClient.getOutputStream());

            dataOutputStream.writeUTF(inputString);
            dataOutputStream.flush();

            DataInputStream dataInputStream = new DataInputStream(socketClient.getInputStream());
            String result = dataInputStream.readUTF();

            System.out.println(result);
            socketClient.close();
        }
    }
}