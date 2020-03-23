package cn.wscfan.loc;

import java.net.InetSocketAddress;

/**
 * @Author 王松
 * @Date 2020/3/23 23:07
 */
public class PortTest {
    public static void main(String[] args) {
        InetSocketAddress socketAddress = new InetSocketAddress("127.0.0.1", 8080);
        System.out.println(socketAddress.getHostName());
        InetSocketAddress socketAddress1 = new InetSocketAddress("localhost", 3306);
        System.out.println(socketAddress1.getAddress());
        System.out.println(socketAddress1.getPort());
    }
}
