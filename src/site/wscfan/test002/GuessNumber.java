package site.wscfan.test002;

import java.util.Random;
import java.util.Scanner;

/**
 * @Author ws
 * @Date 2020/12/6 14:13
 */
public class GuessNumber {
    public static void main(String[] args) {
        Random r = new Random();
        int number = r.nextInt(100);
        while (true) {
            Scanner s = new Scanner(System.in);
            int guessNumber = s.nextInt();
            if (guessNumber > number) {
                System.out.println("你猜大了");
            } else if (guessNumber < number) {
                System.out.println("你猜小了");
            } else {
                System.out.println("猜测正确");
                break;
            }
        }
    }
}
