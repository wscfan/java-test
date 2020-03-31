package cn.wscfan.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

/**
 * @Author 王松
 * @Date 2020/3/31 20:20
 */
public class UdpClient {
    public static void main(String[] args) throws Exception {
        System.out.println("发送方启动中....");
        // 1、使用 DatagramSocket 指定端口，创建发送端
        DatagramSocket client = new DatagramSocket();
        // 2、准备数据，转成字节数组
        String data = "今天学到很多知识。";
        byte[] datas = data.getBytes();
        // 3、封装成 DatagramPacket 包裹
        DatagramPacket packet = new DatagramPacket(datas, datas.length, new InetSocketAddress("localhost", 8888));
        // 4、发送包裹
        client.send(packet);
        // 5、释放资源
        client.close();
    }
}
