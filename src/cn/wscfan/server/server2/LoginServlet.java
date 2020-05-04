package cn.wscfan.server.server2;

/**
 * @Author 王松
 * @Date 2020/5/4 0:19
 */
public class LoginServlet implements Servlet {

    @Override
    public void service(Request request, Response response) {
        // 关注的内容
        response.print("<html>");
        response.print("<head>");
        response.print("<title>");
        response.print("第一个servlet");
        response.print("</title>");
        response.print("<body>");
        response.print("欢迎回来：" + request.getParameters("uname"));
        response.print("</body>");
        response.print("</head>");
        response.print("</html>");
    }
}
