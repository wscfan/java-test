package cn.wscfan.server.server;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

/**
 * @Author 王松
 * @Date 2020/4/22 21:41
 */
public class Server02 {
    private ServerSocket serverSocket;

    public static void main(String[] args) {
        Server02 server = new Server02();
        server.start();
        server.receive();
    }

    // 启动服务
    public void start() {
        try {
            serverSocket = new ServerSocket(8888);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("服务器启动失败");
        }
    }

    // 接受连接
    public void receive() {
        try {
            Socket client = serverSocket.accept();
            System.out.println("一个客户端建立了连接....");
            InputStream is = client.getInputStream();
            byte[] datas = new byte[1024 * 1024];
            int len = is.read(datas);
            String requestInfo = new String(datas, 0, len);
            System.out.println(requestInfo);

            StringBuilder content = new StringBuilder();
            content.append("<html>");
            content.append("<head>");
            content.append("<title>");
            content.append("服务器响应成功");
            content.append("</title>");
            content.append("<body>");
            content.append("Hello World");
            content.append("</body>");
            content.append("</head>");
            content.append("</html>");
            int size = content.toString().getBytes().length;
            StringBuilder responseInfo = new StringBuilder();
            String blank = " ";
            String CRLF = "\r\n";
            // 返回
            // 1、响应行：HTTP/1.1 200 OK
            responseInfo.append("HTTP/1.1").append(blank);
            responseInfo.append(200).append(blank);
            responseInfo.append("OK").append(CRLF);
            // 2、响应头（最后一行存在空行）
            responseInfo.append("Date:").append(new Date()).append(CRLF);
            responseInfo.append("Server:").append("openresty").append(CRLF);
            responseInfo.append("Content-Type:text/html;charset=GBK").append(CRLF);
            responseInfo.append("Content-Length:").append(size).append(CRLF);
            responseInfo.append(CRLF);
            // 3、正文
            responseInfo.append(content.toString());

            // 写出到客户端
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
            bw.write(responseInfo.toString());
            bw.flush();

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("客户端错误");
        }
    }

    // 停止服务
    public void stop() {

    }
}
