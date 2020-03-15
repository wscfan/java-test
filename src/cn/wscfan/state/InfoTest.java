package cn.wscfan.state;

/**
 * @Author 王松
 * @Date 2020/3/15 22:17
 */
public class InfoTest {
    public static void main(String[] args) throws InterruptedException {
        System.out.println(Thread.currentThread().isAlive());
        MyInfo my = new MyInfo("小强");
        Thread t = new Thread(my);
        t.setName("战斗机");
        t.start();
        Thread.sleep(1000);
        System.out.println(t.isAlive());
    }
}

class MyInfo implements Runnable {
    private String name;

    public MyInfo(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "--------->" + this.name);
    }
}
