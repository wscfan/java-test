package cn.wscfan.io;

import java.io.File;

public class FileDemo01 {
    public static void main(String[] args) {
        String path = "C:/mycode/java-test/src/cn/wscfan/io/io.png";
        File src = new File(path);
        System.out.println(src.length());
        File src2 = new File("C:/mycode/java-test/src/cn/wscfan/io", "io.png");
        System.out.println(src2.length());
        File src3 = new File(new File("C:/mycode/java-test/src/cn/wscfan/io"), "io.png");
        System.out.println(src3.length());
    }
}
