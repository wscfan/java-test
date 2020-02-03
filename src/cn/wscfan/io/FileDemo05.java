package cn.wscfan.io;

import java.io.File;
import java.io.IOException;

public class FileDemo05 {
    public static void main(String[] args) throws IOException {
        File src = new File("src/cn/wscfan/io/data/io.txt");
        boolean flag = src.createNewFile();
        if (flag) {
            System.out.println("创建成功");
        } else {
            System.out.println("创建失败");
            if (src.delete()) {
                System.out.println("删除成功");
            } else {
                System.out.println("删除失败");
            }
        }

    }
}
