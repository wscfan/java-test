package cn.wscfan.thread;

/**
 * @Author 王松
 * @Date 2020/3/8 10:48
 */
public class Web12306 implements Runnable {
    private int ticketNum = 99;
    @Override
    public void run() {
        while (true) {
            if (ticketNum < 0) {
                break;
            }
            System.out.println(Thread.currentThread().getName() + "--->" + ticketNum--);
        }
    }

    public static void main(String[] args) {
        Web12306 web = new Web12306();
        System.out.println(Thread.currentThread().getName());
        new Thread(web, "张三").start();
        new Thread(web, "李四").start();
        new Thread(web, "王五").start();
    }
}
