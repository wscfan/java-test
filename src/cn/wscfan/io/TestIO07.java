package cn.wscfan.io;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class TestIO07 {
    public static void main(String[] args) {
        // 1、创建源
        byte[] src = "hello, world!".getBytes();
        // 2、选择流
        InputStream is = null;
        try {
            is = new ByteArrayInputStream(src);
            // 3、操作
            byte[] flush = new byte[5];
            int len = -1;
            while ((len = is.read(flush)) != -1) {
                String str = new String(flush, 0, len);
                System.out.println(str);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
