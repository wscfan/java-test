package cn.wscfan.syn;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author 王松
 * @Date 2020/3/17 23:47
 */
public class SynTest03 {
    public static void main(String[] args) throws InterruptedException {
        List<String> list = new ArrayList<String>();
        for (int i = 0; i < 10000; i++) {
            new Thread(() -> {
                synchronized(list) {
                    list.add(Thread.currentThread().getName());
                }
            }).start();
        }
        Thread.sleep(1000);
        System.out.println(list.size());
    }
}
