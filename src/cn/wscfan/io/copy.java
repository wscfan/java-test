package cn.wscfan.io;

import java.io.*;

public class copy {
    public static void main(String[] args) {
        copy("src/cn/wscfan/io/io.png", "src/cn/wscfan/io/data/io.png");
    }
    public static void copy(String inputPath, String outputPath) {
        // 1、创建源
        File src = new File(inputPath);
        File dest = new File(outputPath);

        // 2、选择源
        InputStream is = null;
        OutputStream os = null;
        try {
            is = new FileInputStream(src);
            os = new FileOutputStream(dest);

            // 3、操作
            int len = -1;
            byte[] flush = new byte[1024];
            while((len = is.read(flush)) != -1) {
                os.write(flush, 0, len);
            }
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
