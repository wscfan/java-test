package cn.wscfan.tcp;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * @Author 王松
 * @Date 2020/4/2 22:40
 */
public class Client {
    public static void main(String[] args) throws IOException {
        System.out.println("-----------Client-----------");
        // 1、建立连接：使用 Socket 创建客户端
        Socket client = new Socket("localhost", 8888);
        // 2、操作：输入输出流操作
        DataOutputStream dos = new DataOutputStream(client.getOutputStream());
        String data = "hello";
        dos.writeUTF(data);
        dos.flush();
        // 3、释放资源
        dos.close();
        client.close();
    }
}
