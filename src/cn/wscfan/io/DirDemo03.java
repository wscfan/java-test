package cn.wscfan.io;

import java.io.File;

public class DirDemo03 {
    public static void main(String[] args) {
        printNum(10);
    }
    public static void printNum(int n) {
        if (n > 20) {
            return;
        }
        System.out.println(n);
        printNum(n + 1);
    }
}
