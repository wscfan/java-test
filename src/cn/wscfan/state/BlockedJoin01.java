package cn.wscfan.state;

/**
 * @Author 王松
 * @Date 2020/3/15 10:12
 */
public class BlockedJoin01 {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                System.out.println("lambda------>" + i);
            }
        });
        t.start();
        for (int i = 0; i < 100; i++) {
            if (i == 30) {
                t.join();
            }
            System.out.println("main----->" + i);
        }
    }
}
