package cn.wscfan.io;

import java.io.*;

public class TestIO09 {
    public static void main(String[] args) {
        byte[] datas = fileToByteArray("src/cn/wscfan/io/data/io.png");
        System.out.println(datas.length);
        byteArrayToFile(datas, "src/cn/wscfan/io/data/io_temp.png");
    }

    /**
     * 1、图片读取到字节数组
     */
    public static byte[] fileToByteArray(String filePath) {
        // 1、创建源
        File src = new File(filePath);
        byte[] dest = null;
        // 2、选择流
        InputStream is = null;
        ByteArrayOutputStream baos = null;
        try {
            is = new FileInputStream(src);
            baos = new ByteArrayOutputStream();
            // 3、操作
            byte[] flush = new byte[1024*10]; // 缓冲容器
            int len = -1;
            while((len = is.read(flush)) != -1) {
                baos.write(flush, 0, len);
            }
            baos.flush();
            return baos.toByteArray();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 4、释放资源
            try {
                if (null != is) {
                    is.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
    /**
     * 2、字节数组写出到图片
     */
    public static void byteArrayToFile(byte[] src, String filePath) {
        // 1、创建源
        File dest = new File(filePath);
        // 2、选择流
        InputStream is = null;
        OutputStream os = null;
        try {
            is = new ByteArrayInputStream(src);
            os = new FileOutputStream(dest);
            // 3、操作
            byte[] flush = new byte[5]; // 缓冲容器
            int len = -1;
            while((len = is.read(flush)) != -1) {
                os.write(flush, 0, len);
            }
            os.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 4、释放资源
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
