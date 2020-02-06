package cn.wscfan.io;

import java.io.*;

public class TestIO02 {
    public static void main(String[] args) {
        File src = new File("src/cn/wscfan/io/data/io.txt");
        InputStream is = null;
        try {
            is = new FileInputStream(src);
            int temp;
            while ((temp = is.read()) != -1) {
                System.out.println((char)temp);
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
