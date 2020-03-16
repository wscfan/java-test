package cn.wscfan.syn;

/**
 * @Author 王松
 * @Date 2020/3/16 19:04
 */
public class UnsafeTest01 {
    public static void main(String[] args) {
        UnsafeWeb uw = new UnsafeWeb();
        new Thread(uw, "张三").start();
        new Thread(uw, "李四").start();
        new Thread(uw, "王五").start();
    }
}

class UnsafeWeb implements Runnable {
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
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "----->" + tickets);
        tickets -= 1;
    }
}