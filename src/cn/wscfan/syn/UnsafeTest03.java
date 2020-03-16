package cn.wscfan.syn;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author 王松
 * @Date 2020/3/16 21:22
 */
public class UnsafeTest03 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        for (int i = 0; i < 10000; i++) {
            new Thread(() -> {
                list.add(Thread.currentThread().getName());
            }).start();
        }
        System.out.println(list.size());
    }
}
