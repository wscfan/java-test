package cn.wscfan.tcp;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Author 王松
 * @Date 2020/4/6 14:44
 */
public class LoginServer {
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
        String[] dataArray = data.split("&");
        for (String info: dataArray) {
            String[] userInfo = info.split("=");
            System.out.println(userInfo[0] + "===>" + userInfo[1]);
        }
        // 4、释放资源
        dis.close();
        client.close();
    }
}
