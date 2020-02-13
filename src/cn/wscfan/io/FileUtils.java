package cn.wscfan.io;

import java.io.*;

/**
 * @Author 王松
 * @Date 2020/2/13 18:03
 */
public class FileUtils {
    public static void main(String[] args) {
        // 文件到文件
        try {
            InputStream is = new FileInputStream("src/cn/wscfan/io/data/io.png");
            OutputStream os = new FileOutputStream("src/cn/wscfan/io/data/io_20200213.png");
            copy(is, os);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 文件到字节数组
        byte[] datas = null;
        try {
            InputStream is = new FileInputStream("src/cn/wscfan/io/data/io.png");
            ByteArrayOutputStream os = new ByteArrayOutputStream();
            copy(is, os);
            datas = os.toByteArray();
            System.out.println(datas.length);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 字节数组到文件
        try {
            InputStream is = new ByteArrayInputStream(datas);
            OutputStream os = new FileOutputStream("src/cn/wscfan/io/data/2102.png");
            copy(is, os);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void copy(InputStream is, OutputStream os) {
        int len = -1;
        byte[] flush = new byte[1024];
        try {
            while((len = is.read(flush)) != -1) {
                os.write(flush, 0, len);
            }
            os.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(is, os);
        }
    }

    public static void close(InputStream is, OutputStream os) {
        try {
            if (null != is) {
                is.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            if (null != os) {
                os.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static  void close(Closeable... ios) {
        for (Closeable io: ios) {
            try {
                if (null != io) {
                    io.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
