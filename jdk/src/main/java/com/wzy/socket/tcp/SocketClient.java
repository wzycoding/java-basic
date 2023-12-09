package com.wzy.socket.tcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author wzy
 */
public class SocketClient {
    @SuppressWarnings("all")
    public static void main(String[] args) throws IOException {

        while (true) {
            String serverHost = "127.0.0.1";
            Integer serverPort = 8090;

            Socket socketClient = new Socket(serverHost, serverPort);
            System.out.print("请输入要发送的数据：");
            Scanner scanner = new Scanner(System.in);
            String inputText = scanner.nextLine();

            DataOutputStream dataOutputStream = new DataOutputStream(socketClient.getOutputStream());
            dataOutputStream.writeUTF(inputText);
            dataOutputStream.flush();

            DataInputStream dataInputStream = new DataInputStream(socketClient.getInputStream());
            String resultText = dataInputStream.readUTF();

            System.out.println("服务端返回内容：" + resultText);

            socketClient.close();
        }
    }
}
