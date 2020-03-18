package cn.wscfan.syn;

/**
 * @Author 王松
 * @Date 2020/3/18 23:53
 */
public class SynTest04 {
    public static void main(String[] args) {
        SynWeb04 uw = new SynWeb04();
        new Thread(uw, "张三").start();
        new Thread(uw, "李四").start();
        new Thread(uw, "王五").start();
    }
}

class SynWeb04 implements Runnable {
    private int tickets = 10;
    private boolean flag = true;
    @Override
    public void run() {
        while (flag) {
            test();
        }
    }
    public void test() {
        if (tickets < 0) {
            flag = false;
            return;
        }
        synchronized (this) {
            if (tickets < 0) {
                flag = false;
                return;
            }
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "----->" + tickets);
            tickets -= 1;
        }
    }
}
