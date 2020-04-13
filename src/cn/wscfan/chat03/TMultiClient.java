package cn.wscfan.chat03;

import java.io.*;
import java.net.Socket;

/**
 * @Author 王松
 * @Date 2020/4/11 23:34
 */
public class TMultiClient {
    public static void main(String[] args) throws IOException {
        System.out.println("-------------client--------------");
        // 1、建立连接，使用 Socket创建客户端
        Socket client = new Socket("localhost", 8888);
        // 2、客户端发送消息
        new Thread((new Send(client))).start();
        new Thread(new Receive(client)).start();
    }
}
