package cn.wscfan.io;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class TestIO05 {
    public static void main(String[] args) {
        // 1、创建源
        File src = new File("src/cn/wscfan/io/data/io.txt");
        // 2、选择流
        Reader reader = null;
        try {
            reader = new FileReader(src);
            // 3、操作
            char[] flush = new char[1024];
            int len = -1;
            while ((len = reader.read(flush)) != -1) {
                String str = new String(flush, 0, len);
                System.out.println(str);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 4、释放流
            try {
                if (null != reader) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
