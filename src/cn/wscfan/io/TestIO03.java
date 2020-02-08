package cn.wscfan.io;

import java.io.*;

public class TestIO03 {
    public static void main(String[] args) {
        File src = new File("src/cn/wscfan/io/data/io.txt");
        InputStream is = null;
        try {
            is = new FileInputStream(src);
            int len = -1;
            byte[] car = new byte[1024];
            while ((len = is.read(car)) != -1) {
                String str = new String(car, 0, len);
                System.out.println(str);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != is) {
                    is.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
