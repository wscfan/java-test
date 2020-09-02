package site.wscfan.test001;

import java.util.Random;

/**
 * @Author 王松
 * @Date 2020/8/9 18:52
 */
public class RandomTest {
    public static void main(String[] args) {
        Random r = new Random();
        int n = r.nextInt(1000);
        System.out.println(n);
    }
}
