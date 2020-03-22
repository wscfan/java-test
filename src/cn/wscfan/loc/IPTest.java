package cn.wscfan.loc;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @Author 王松
 * @Date 2020/3/22 22:42
 */
public class IPTest {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress addr = InetAddress.getLocalHost();
        System.out.println(addr.getHostAddress());
        System.out.println(addr.getHostName());
        System.out.println("----------------------------");

        addr = InetAddress.getByName("www.baidu.com");
        System.out.println(addr.getHostName());
        System.out.println(addr.getHostAddress());
        System.out.println("----------------------------");

        addr = InetAddress.getByName("14.215.177.38");
        System.out.println(addr.getHostAddress());
        System.out.println(addr.getHostName());
    }
}
