package cn.wscfan.others;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @Author 王松
 * @Date 2020/3/21 18:22
 */
public class MyTimerTest01 {
    public static void main(String[] args) {
        Timer timer = new Timer();
        System.out.println("开始执行");
        Calendar cal = new GregorianCalendar(2020, 3, 21, 22, 06, 59);
        System.out.println(cal.getTime());
        timer.schedule(new MyTask(), 1000);
    }
}

// 任务类
class MyTask extends TimerTask {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("放空大脑");
        }
    }
}
