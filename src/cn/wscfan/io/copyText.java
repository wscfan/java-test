package cn.wscfan.io;

import java.io.*;

/**
 * @Author 王松
 * @Date 2020/2/14 22:08
 */
public class copyText {
    public static void main(String[] args) {
        copy("src/cn/wscfan/io/data/io.txt", "src/cn/wscfan/io/data/io_copy_text.txt");
    }
    public static void copy(String srcPath, String destPath) {
        File src = new File(srcPath);
        File dest = new File(destPath);
        try(BufferedReader br = new BufferedReader(new FileReader(src));
            BufferedWriter bw = new BufferedWriter((new FileWriter(dest)))) {
            String line = null;
            while ((line = br.readLine()) != null) {
                bw.write(line);
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
