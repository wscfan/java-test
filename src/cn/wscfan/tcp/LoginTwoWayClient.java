package cn.wscfan.tcp;

import java.io.*;
import java.net.Socket;

/**
 * @Author 王松
 * @Date 2020/4/6 14:44
 */
public class LoginTwoWayClient {
    public static void main(String[] args) throws IOException {
        System.out.println("-----------Client-----------");
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("请输入用户名：");
        String username = console.readLine();
        System.out.println("请输入密码：");
        String password = console.readLine();
        // 1、建立连接：使用 Socket 创建客户端
        Socket client = new Socket("localhost", 8888);
        // 2、操作：输入输出流操作
        DataOutputStream dos = new DataOutputStream(client.getOutputStream());
        dos.writeUTF("username=" + username + "&password=" + password);
        dos.flush();

        DataInputStream dis = new DataInputStream(client.getInputStream());
        String result = dis.readUTF();
        System.out.println(result);

        // 3、释放资源
        dos.close();
        client.close();
    }
}
