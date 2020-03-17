package cn.wscfan.syn;

/**
 * @Author 王松
 * @Date 2020/3/17 22:49
 */
public class SynTest01 {
    public static void main(String[] args) {
        SynWeb sw = new SynWeb();
        new Thread(sw, "张三").start();
        new Thread(sw, "李四").start();
        new Thread(sw, "王五").start();
    }
}

class SynWeb implements Runnable {
    private int tickets = 100;
    private boolean flag = true;
    @Override
    public void run() {
        while (flag) {
            test();
        }
    }
    public synchronized void test() {
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

