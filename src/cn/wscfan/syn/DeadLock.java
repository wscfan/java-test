package cn.wscfan.syn;

/**
 * @Author 王松
 * @Date 2020/3/20 23:07
 */
public class DeadLock {
    public static void main(String[] args) {
        Markup g1 = new Markup(1, "大牙");
        Markup g2 = new Markup(2, "小飞");
        g1.start();
        g2.start();
    }
}

class Lipstick {

}

class Mirror {

}

class Markup extends Thread {
    static Lipstick lipstick = new Lipstick();
    static Mirror mirror = new Mirror();
    int choise;
    String girl;

    public Markup(int choise, String girl) {
        this.choise = choise;
        this.girl = girl;
    }

    @Override
    public void run() {
        markup();
    }

    public void markup() {
        if (choise == 1) {
            synchronized (lipstick) {
                System.out.println(this.girl + "获得口红");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
/*                synchronized (mirror) {
                    System.out.println(this.girl + "获得镜子");
                }*/
            }
            synchronized (mirror) {
                System.out.println(this.girl + "获得镜子");
            }
        } else {
            synchronized (mirror) {
                System.out.println(this.girl + "获得镜子");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
/*                synchronized (lipstick) {
                    System.out.println(this.girl + "获得口红");
                }*/
            }
            synchronized (lipstick) {
                System.out.println(this.girl + "获得口红");
            }
        }
    }

}
