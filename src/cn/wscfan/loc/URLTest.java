package cn.wscfan.loc;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * @Author 王松
 * @Date 2020/3/24 22:46
 */
public class URLTest {
    public static void main(String[] args) throws MalformedURLException {
        URL url = new URL("http://wscfan.com:80/index.html?username=ws&age=18#aaa");
        System.out.println("协议：" + url.getProtocol());
        System.out.println("域名：" + url.getHost());
        System.out.println("请求资源：" + url.getFile());
        System.out.println("请求资源：" + url.getPath());
        System.out.println("端口：" + url.getPort());
        System.out.println("参数：" + url.getQuery());
        System.out.println("锚点：" + url.getRef());

    }
}
