package cn.wscfan.chat01;

import java.io.*;
import java.net.Socket;

/**
 * @Author 王松
 * @Date 2020/4/11 23:34
 */
public class MultiClient {
    public static void main(String[] args) throws IOException {
        System.out.println("-------------client--------------");
        // 1、建立连接，使用 Socket创建客户端
        Socket client = new Socket("localhost", 8888);
        // 2、客户端发送消息
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        DataOutputStream dos = new DataOutputStream(client.getOutputStream());
        DataInputStream dis = new DataInputStream(client.getInputStream());
        boolean isRunning = true;
        while (isRunning) {
            String msg = console.readLine();
            dos.writeUTF(msg);
            dos.flush();
            // 3、获取消息
            msg = dis.readUTF();
            System.out.println(msg);
        }
        dos.close();
        dis.close();
        client.close();
    }
}
