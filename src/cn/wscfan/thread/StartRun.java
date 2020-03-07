package cn.wscfan.thread;

/**
 * @Author 王松
 * @Date 2020/3/7 23:59
 */
public class StartRun implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println("正在敲代码");
        }
    }

    public static void main(String[] args) {
        // 创建实现类对象
//        StartRun sr = new StartRun();
        // 创建代理类对象
//        Thread t = new Thread(sr);
//        t.start();
        new Thread(new StartRun()).start();
        for (int i = 0; i < 20; i++) {
            System.out.println("正在听歌");
        }
    }
}
