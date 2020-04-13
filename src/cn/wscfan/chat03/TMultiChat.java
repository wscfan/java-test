package cn.wscfan.chat03;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Author 王松
 * @Date 2020/4/11 23:33
 */
public class TMultiChat {
    public static void main(String[] args) throws IOException {
        System.out.println("------------server------------");
        // 1、指定端口，使用ServerSocket创建服务器
        ServerSocket server = new ServerSocket(8888);
        // 2、阻塞式等待连接 accept
        while (true) {
            Socket client = server.accept();
            System.out.println("一个客户端建立了连接");
            new Thread(new Channel(client)).start();
        }
    }

    static class Channel implements Runnable {
        private DataInputStream dis;
        private DataOutputStream dos;
        private Socket client;
        private boolean isRunning;

        public Channel(Socket client) {
            this.client = client;
            try {
                dis = new DataInputStream(client.getInputStream());
                dos = new DataOutputStream(client.getOutputStream());
                isRunning = true;
            } catch (IOException e) {
                release();
            }
        }

        // 接收消息
        private String receive() {
            String msg = "";
            try {
                msg = dis.readUTF();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return msg;
        }
        // 发送消息
        private void send(String msg) {
            try {
                dos.writeUTF(msg);
                dos.flush();
            } catch (IOException e) {
                release();
            }
        }
        // 释放资源
        private void release() {
            this.isRunning = false;
            WsUtils.close(dis, dos, client);
        }

        @Override
        public void run() {
            while (isRunning) {
                String msg = receive();
                if (!msg.equals("")) {
                    send(msg);
                }
            }
        }
    }
}
