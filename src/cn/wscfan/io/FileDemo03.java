package cn.wscfan.io;

import java.io.File;

public class FileDemo03 {
    public static void main(String[] args) {
        File src = new File("src/cn/wscfan/io/io.png");
        System.out.println("名称：" + src.getName());
        System.out.println("路径：" + src.getPath());
        System.out.println("绝对路径：" + src.getAbsolutePath());
        System.out.println("父路径：" + src.getParent());
        System.out.println("是否存在：" + src.exists());
        System.out.println("是否是文件夹：" + src.isDirectory());
        System.out.println("是否是文件：" + src.isFile());
    }
}
