package cn.wscfan.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * @Author 王松
 * @Date 2020/2/14 21:59
 */
public class BufferedTest02 {
    public static void main(String[] args) {
        // 1、创建源
        File src = new File("src/cn/wscfan/io/data/io.txt");
        // 2、选择流
        try(BufferedReader reader = new BufferedReader(new FileReader(src))) {
            // 3、操作
            String line = null;
            while((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
