package cn.wscfan.io;

import java.io.File;

public class FileDemo04 {
    public static void main(String[] args) {
        File src = new File("src/cn/wscfan/io/io.png");
        if (null == src || !src.exists()) {
            System.out.println("文件不存在");
        } else {
            if (src.isFile()) {
                System.out.println("这是文件");
                System.out.println("字节数：" + src.length());
            }
            if (src.isDirectory()) {
                System.out.println("这是文件夹");
            }
        }
    }
}
