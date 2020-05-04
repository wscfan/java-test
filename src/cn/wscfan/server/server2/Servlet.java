package cn.wscfan.server.server2;

/**
 * 服务器小脚本接口
 * @Author 王松
 * @Date 2020/5/4 0:13
 */
public interface Servlet {
    void service(Request request, Response response);
}
