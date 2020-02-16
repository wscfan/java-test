package cn.wscfan.common;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @Author 王松
 * @Date 2020/2/16 20:00
 */
public class CIOTest03 {
    public static void main(String[] args) throws IOException {
        String msg = FileUtils.readFileToString(new File("src/cn/wscfan/io/data/io.txt"), "UTF-8");
        System.out.println(msg);
        byte[] datas = FileUtils.readFileToByteArray(new File("src/cn/wscfan/io/data/io.txt"));
        System.out.println(datas.length);
        List<String> msg2 = FileUtils.readLines(new File("src/cn/wscfan/io/data/io.txt"), "UTF-8");
        for(String str: msg2) {
            System.out.println(str);
        }
        LineIterator it = FileUtils.lineIterator(new File("src/cn/wscfan/io/data/io.txt"), "UTF-8");
        while(it.hasNext()) {
            System.out.println(it.nextLine());
        }
    }
}
