package site.wscfan.test001;

import java.util.Scanner;

/**
 * @Author 王松
 * @Date 2020/7/30 21:13
 */
public class ScannerTest {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("请输入姓名：");
        int age = in.nextInt();
        System.out.println(age);
    }
}
