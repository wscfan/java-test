package cn.wscfan.chat01;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Author 王松
 * @Date 2020/4/11 23:33
 */
public class MultiChat {
    public static void main(String[] args) throws IOException {
        System.out.println("------------server------------");
        // 1、指定端口，使用ServerSocket创建服务器
        ServerSocket server = new ServerSocket(8888);
        // 2、阻塞式等待连接 accept
        while (true) {
            Socket client = server.accept();
            System.out.println("一个客户端建立了连接");
            // 3、接收消息
            DataInputStream dis = new DataInputStream(client.getInputStream());
            DataOutputStream dos = new DataOutputStream(client.getOutputStream());
            boolean isRunning = true;
            while (isRunning) {
                String msg = dis.readUTF();
                // 4、返回消息
                dos.writeUTF(msg);
                dos.flush();
            }
            dos.close();
            dis.close();
            client.close();
        }
    }
}
