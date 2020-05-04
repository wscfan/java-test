package cn.wscfan.server.server2;

/**
 * @Author 王松
 * @Date 2020/5/4 0:25
 */
public class RegistServlet implements Servlet {
    @Override
    public void service(Request request, Response response) {
        response.print("注册成功~");
    }
}
