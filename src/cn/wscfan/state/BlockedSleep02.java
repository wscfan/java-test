package cn.wscfan.state;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author 王松
 * @Date 2020/3/12 22:08
 */
public class BlockedSleep02 {
    public static void main(String[] args) throws InterruptedException {
        long now = System.currentTimeMillis();
        long end = System.currentTimeMillis() - 10000;
        System.out.println(now);
        while (true) {
            Date nowDate = new Date(now);
            String formateTime = new SimpleDateFormat("YYYY-MM-dd mm:ss").format(nowDate);
            System.out.println(formateTime);
            Thread.sleep(1000);
            now -= 1000;
            if (now <= end) {
                break;
            }

        }
    }
}
