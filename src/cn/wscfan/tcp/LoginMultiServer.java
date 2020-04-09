package cn.wscfan.tcp;

import com.oracle.webservices.internal.api.databinding.WSDLResolver;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Author 王松
 * @Date 2020/4/6 14:44
 */
public class LoginMultiServer {
    public static void main(String[] args) throws IOException {
        System.out.println("----------Server------------");
        // 1、指定端口，使用 ServerSocket 创建服务器
        ServerSocket server = new ServerSocket(8888);
        boolean isRunning = true;
        while (isRunning) {
            // 2、阻塞式等待连接 accept
            Socket client = server.accept();
            System.out.println("一个客户端建立了连接");
            new Thread(new Channel(client)).start();
        }
        server.close();
    }
    static class Channel implements Runnable {
        private Socket client;
        private DataInputStream dis;
        private DataOutputStream dos;

        public Channel(Socket client) {
            this.client = client;
            // 3、操作：输入输出流操作
            try {
                dis = new DataInputStream(client.getInputStream());
                dos = new DataOutputStream(client.getOutputStream());
            } catch (IOException e) {
                e.printStackTrace();
                release();
            }
        }

        // 接收数据
        private String receive() {
            String datas = "";
            try {
                datas = dis.readUTF();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return datas;
        }

        // 发送数据
        private void send(String msg) {
            try {
                dos.writeUTF(msg);
                dos.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // 释放资源
        private void release() {
            try {
                if (dos != null) {
                    dos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (dis != null) {
                    dis.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (client != null) {
                    client.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void run() {
            // 分析
            String username = "";
            String password = "";
            String[] dataArray = receive().split("&");
            for (String info: dataArray) {
                String[] userInfo = info.split("=");
                if (userInfo[0].equals("username")) {
                    System.out.println("您的用户名为：" + userInfo[1]);
                    username = userInfo[1];
                } else if (userInfo[0].equals("password")) {
                    System.out.println("您的密码为：" + userInfo[1]);
                    password = userInfo[1];
                }
            }
            if (username.equals("admin") && password.equals("123456")) {
                send("登录成功，欢迎回来~");
            } else {
                send("用户名或密码错误！");
            }
            // 4、释放资源
            release();
        }
    }
}
