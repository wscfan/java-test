package cn.wscfan.io;

import java.io.*;

/**
 * @Author 王松
 * @Date 2020/2/13 18:03
 */
public class FileUtils2 {
    public static void main(String[] args) {
        copy("src/cn/wscfan/io/io.png", "src/cn/wscfan/io/data/io2.png");
    }
    public static void copy(String inputPath, String outputPath) {
        // 1、创建源
        File src = new File(inputPath);
        File dest = new File(outputPath);

        // 2、选择源
        try(InputStream is = new FileInputStream(src); OutputStream os = new FileOutputStream(dest);) {
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
        }
    }
}
