package cn.wscfan.io;

import java.io.*;

/**
 * @Author 王松
 * @Date 2020/2/14 21:34
 */
public class BufferedTest01 {
    public static void main(String[] args) {
        // 1、创建源
        File src = new File("src/cn/wscfan/io/data/io.txt");
        // 2、选择流
        try(InputStream is = new BufferedInputStream(new FileInputStream(src));) {
            // 3、操作
            int len = -1;
            byte[] flush = new byte[1024];
            while((len = is.read(flush)) != -1) {
                String str = new String(flush, 0, len);
                System.out.println(str);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
