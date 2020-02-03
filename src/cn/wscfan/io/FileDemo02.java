package cn.wscfan.io;

import java.io.File;

public class FileDemo02 {
    public static void main(String[] args) {
        String path = "src/cn/wscfan/io/io.png";
        File src = new File(path);
        System.out.println(src.length());
        System.out.println(System.getProperty("user.dir"));
        System.out.println(src.getAbsolutePath());
    }
}
