package cn.wscfan.io;

import java.io.File;

public class DirDemo02 {
    public static void main(String[] args) {
        File dir = new File("src/cn/wscfan/io/data");
        String[] subNames = dir.list();
        for(String s: subNames) {
            System.out.println(s);
        }
        File[] subFiles = dir.listFiles();
        for(File s: subFiles) {
            System.out.println(s.getAbsolutePath());
        }
    }
}
