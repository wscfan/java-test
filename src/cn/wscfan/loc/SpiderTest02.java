package cn.wscfan.loc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @Author 王松
 * @Date 2020/3/25 22:33
 */
public class SpiderTest02 {
    public static void main(String[]args) throws Exception {
        URL url = new URL("https://www.dianping.com");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/80.0.3987.149 Safari/537.36");
        BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"));
        String msg = null;
        while ((msg = br.readLine()) != null) {
            System.out.println(msg);
        }
        br.close();
    }
}
