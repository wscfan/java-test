package cn.wscfan.state;

/**
 * @Author 王松
 * @Date 2020/3/12 22:08
 */
public class BlockedSleep01 {
    public static void main(String[] args) throws InterruptedException {
        int num = 100;
        while (true) {
            Thread.sleep(1000);
            System.out.println(num--);
            if (num == 96) {
                return;
            }
        }
    }
}
