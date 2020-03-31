package cn.wscfan.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * @Author 王松
 * @Date 2020/3/31 20:20
 */
public class UdpServer {
    public static void main(String[] args) throws Exception {
        System.out.println("接受方启动中.....");
        // 1、使用 DatagramSocket 指定端口，创建接受端
        DatagramSocket server = new DatagramSocket(8888);
        // 2、准备容器，封装成 DatagramPacket 包裹
        byte[] container = new byte[1024*60];
        DatagramPacket packet = new DatagramPacket(container, 0, container.length);
        // 3、阻塞式接收包裹
        server.receive(packet);
        // 4、分析数据
        byte[] datas = packet.getData();
        int len = packet.getLength();
        System.out.println(new String(datas, 0, len));
        // 5、释放资源
        server.close();
    }
}
