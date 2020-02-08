package cn.wscfan.io;

import java.io.*;

public class TestIO04 {
    public static void main(String[] args) {
        // 1、创建源
        File dest = new File("src/cn/wscfan/io/data/dest.txt");
        // 2、选择流
        OutputStream os = null;
        try {
            os = new FileOutputStream(dest);
            // 3、操作
            String msg = "明天，你好";
            byte[] datas = msg.getBytes();
            os.write(datas);
            os.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != os) {
                    os.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
