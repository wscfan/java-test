package cn.wscfan.state;

/**
 * @Author 王松
 * @Date 2020/3/15 21:22
 */
public class DaemonTest {
    public static void main(String[] args) {
        God god = new God();
        People p = new People();
        Thread t = new Thread(god);
        Thread t2 = new Thread(p);
        t.setDaemon(true);
        t.start();
        t2.start();
    }
}

class God implements Runnable {
    @Override
    public void run() {
        for (;true;) {
            System.out.println("bless---->>");
        }
    }
}

class People implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 365*100; i++) {
            System.out.println("live--->" + i);
        }
        System.out.println("gggggggggg.................");
    }
}