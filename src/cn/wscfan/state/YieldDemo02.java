package cn.wscfan.state;

/**
 * @Author 王松
 * @Date 2020/3/12 22:55
 */
public class YieldDemo02 {
    public static void main(String[] args) {
        new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                System.out.println("lambda->" + i);
            }
        }).start();
        for (int i = 0; i < 100; i++) {
            if (i % 20 == 0) {
                Thread.yield();
            }
            System.out.println("main------>" + i);
        }
    }
}
