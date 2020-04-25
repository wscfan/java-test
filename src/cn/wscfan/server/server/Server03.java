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
public class Server03 {
    private ServerSocket serverSocket;

    public static void main(String[] args) {
        Server03 server = new Server03();
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

            Response response = new Response(client);
            StringBuilder content = new StringBuilder();
            response.print("<html>");
            response.print("<head>");
            response.print("<title>");
            response.print("服务器响应成功");
            response.print("</title>");
            response.print("<body>");
            response.print("Hello World");
            response.print("</body>");
            response.print("</head>");
            response.print("</html>");
            // 关注了状态码
            response.pushToBrowser(200);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("客户端错误");
        }
    }

    // 停止服务
    public void stop() {

    }
}
