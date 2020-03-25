package cn.wscfan.loc;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * @Author 王松
 * @Date 2020/3/25 22:24
 */
public class SpiderTest01 {
    public static void main(String[] args) throws Exception {
        // 获取url
//        URL url = new URL("https://www.dianping.com");
        URL url = new URL("https://www.jd.com");
        // 下载资源T
        InputStream is = url.openStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(is, "utf-8"));
        String msg = null;
        while ((msg = br.readLine()) != null) {
            System.out.println(msg);
        }
        br.close();
    }
}
