package cn.wscfan.server.server2;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Date;

/**
 * @Author 王松
 * @Date 2020/4/23 22:42
 */
public class Response {
    private BufferedWriter bw;
    // 正文
    private StringBuilder content;
    // 协议头信息
    private StringBuilder headInfo;
    private int len;
    private final String BLANK = " ";
    private final String CRLF = "\r\n";
    private Response(){
        content = new StringBuilder();
        headInfo = new StringBuilder();
        len = 0;
    }
    public Response(Socket client) {
        this();
        try {
            bw = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
        } catch (IOException e) {
            e.printStackTrace();
            headInfo = null;
        }
    }
    public Response(OutputStream os) {
        this();
        bw = new BufferedWriter(new OutputStreamWriter(os));
    }

    // 动态添加内容
    public Response print(String info) {
        content.append(info);
        len += info.getBytes().length;
        return this;
    }
    public Response println(String info) {
        content.append(info).append(CRLF);
        len += (info + CRLF).getBytes().length;
        return this;
    }
    public void pushToBrowser(int code) throws IOException {
        if (null == headInfo) {
            code = 505;
        }
        createHeadInfo(code);
        bw.append(headInfo);
        bw.append(content);
        bw.flush();
    }

    // 构建头信息
    private void createHeadInfo(int code) {
        // 1、响应行：HTTP/1.1 200 OK
        headInfo.append("HTTP/1.1").append(BLANK);
        headInfo.append(code).append(BLANK);
        switch (code) {
            case 200:
                headInfo.append("OK").append(CRLF);
                break;
            case 404:
                headInfo.append("NOT FOUND").append(CRLF);
                break;
            case 505:
                headInfo.append("SERVER EROOR").append(CRLF);
                break;
        }
        // 2、响应头
        headInfo.append("Date:").append(new Date()).append(CRLF);
        headInfo.append("Server:").append("openresty").append(CRLF);
        headInfo.append("Content-Type:text/html;charset=GBK").append(CRLF);
        headInfo.append("Content-Length:").append(len).append(CRLF);
        headInfo.append(CRLF);
    }
}
