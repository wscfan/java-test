package cn.wscfan.io;

import java.io.*;
import java.net.URL;

/**
 * @Author 王松
 * @Date 2020/2/15 15:27
 */
public class ConvertTest02 {
    public static void main(String[] args) {
        test2();
    }
    public static void test1() {
        try(InputStreamReader is = new InputStreamReader(new URL("http://www.baidu.com").openStream(), "UTF-8")) {
            int temp;
            while ((temp = is.read()) != -1) {
                System.out.print((char)temp);
            }
        } catch (IOException e) {
            System.out.println("操作异常");
        }
    }
    public static void test2() {
        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(
                        new URL("http://www.baidu.com").openStream(), "UTF-8"));
            BufferedWriter bw = new BufferedWriter(
                    new OutputStreamWriter(
                            new FileOutputStream("src/cn/wscfan/io/data/baidu.html")))) {
            String msg;
            while ((msg = br.readLine()) != null) {
//                System.out.println(msg);
                bw.write(msg);
                bw.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
