package cn.wscfan.tcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Author 王松
 * @Date 2020/4/6 14:44
 */
public class LoginTwoWayServer {
    public static void main(String[] args) throws IOException {
        System.out.println("----------Server------------");
        // 1、指定端口，使用 ServerSocket 创建服务器
        ServerSocket server = new ServerSocket(8888);
        // 2、阻塞式等待连接 accept
        Socket client = server.accept();
        System.out.println("一个客户端建立了连接");
        // 3、操作：输入输出流操作
        DataInputStream dis = new DataInputStream(client.getInputStream());
        String data = dis.readUTF(dis);
        // 分析
        String username = "";
        String password = "";
        String[] dataArray = data.split("&");
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
        DataOutputStream dos = new DataOutputStream(client.getOutputStream());
        if (username.equals("admin") && password.equals("123456")) {
            dos.writeUTF("登录成功，欢迎回来~");
        } else {
            dos.writeUTF("用户名或密码错误！");
        }
        // 4、释放资源
        dis.close();
        client.close();
    }
}
