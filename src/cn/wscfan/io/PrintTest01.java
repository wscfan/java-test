package cn.wscfan.io;

import java.io.*;

/**
 * @Author 王松
 * @Date 2020/2/16 14:08
 */
public class PrintTest01 {
    public static void main(String[] args) throws FileNotFoundException {
        PrintStream ps = System.out;
        ps.println("打印流");
        ps.println(true);

        ps = new PrintStream(new BufferedOutputStream(new FileOutputStream("src/cn/wscfan/io/data/print.txt")), true);
        ps.println("打印流");
        ps.println(true);

        // 重定向输出端
        System.setOut(ps);
        System.out.println("change");
        System.setOut(new PrintStream(new BufferedOutputStream(new FileOutputStream(FileDescriptor.out)), true));
        System.out.println("我回来了");
    }
}
