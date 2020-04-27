package cn.wscfan.server.server;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

/**
 * @Author 王松
 * @Date 2020/4/26 23:46
 */
public class Request {
    // 协议信息
    private String requestInfo;
    // 请求方式
    private String method;
    // 请求url
    private String url;
    // 请求的参数
    private String queryStr;
    private final String CRLF = "\r\n";
    public Request(Socket client) throws IOException {
        this(client.getInputStream());
    }
    public Request(InputStream is) {
        byte[] datas = new byte[1024 * 1024];
        int len;
        try {
            len = is.read(datas);
            this.requestInfo = new String(datas, 0, len);
            System.out.println(requestInfo);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        parseRequestInfo();
    }
    private void parseRequestInfo() {
        System.out.println("----分解开始------");
        System.out.println("----1、获取请求方式-----");
        this.method = this.requestInfo.substring(0, this.requestInfo.indexOf("/")).toLowerCase();
        this.method = this.method.trim();
        System.out.println(this.method);
        System.out.println("----2、获取url----");
        int startIdx = this.requestInfo.indexOf("/") + 1;
        int endIdx = this.requestInfo.indexOf("HTTP/");
        this.url = this.requestInfo.substring(startIdx, endIdx);
        this.url = this.url.trim();
        int queryIdx = this.url.indexOf("?");
        if (queryIdx >= 0) {
            String[] urlArray = this.url.split("\\?");
            this.url = urlArray[0];
            this.queryStr = urlArray[1];
        }
        System.out.println(this.url);
        if (method.equals("post")) {
            String qStr = this.requestInfo.substring(this.requestInfo.lastIndexOf(CRLF)).trim();
            if (null == queryStr) {
                queryStr = qStr;
            } else {
                queryStr += "&" + qStr;
            }
        }
        queryStr = null == queryStr ? "" : queryStr;
        System.out.println(method + "----->" + url + "------->" + queryStr);
    }
}
