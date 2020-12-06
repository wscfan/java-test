package site.wscfan.test002;

import java.util.Random;

/**
 * @Author ws
 * @Date 2020/12/6 14:10
 */
public class TestRandom {
    public static void main(String[] args) {
        Random r = new Random();
        int number = r.nextInt(10);
        System.out.println(number);
    }
}
