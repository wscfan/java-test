package cn.wscfan.io;

import java.io.File;

public class PathDemo01 {
    public static void main(String[] args) {
        String path = "C:\\mycode\\java-test\\src\\cn\\wscfan\\io\\io.png";
        path = "C:/mycode/java-test/src/cn/wscfan/io/io.png";
        System.out.println(path);
        System.out.println(File.separatorChar);
    }
}
