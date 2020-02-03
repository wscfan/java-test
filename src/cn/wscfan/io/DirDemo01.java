package cn.wscfan.io;

import java.io.File;

public class DirDemo01 {
    public static void main(String[] args) {
        File dir = new File("src/cn/wscfan/io/data/dir/aa");
        boolean flag = dir.mkdirs();
        if (!flag) {
            System.out.println("目录创建失败");
        } else {
            System.out.println("目录创建成功");
        }
    }
}
