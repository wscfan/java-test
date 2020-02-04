package cn.wscfan.io;

import java.io.File;

public class DirDemo05 {
    public static void main(String[] args) {
        File src = new File("src/cn/wscfan/io/data");
        count(src);
        System.out.println(len);
    }
    private static long len = 0;
    public static void count(File src) {
        if (null != src && src.exists()) {
            if (src.isFile()) {
                len += src.length();
            } else {
                for(File s: src.listFiles()) {
                    count(s);
                }
            }
        }
    }
}
