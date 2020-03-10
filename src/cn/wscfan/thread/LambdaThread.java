package cn.wscfan.thread;

/**
 * @Author 王松
 * @Date 2020/3/10 20:55
 */
public class LambdaThread {
    static class Test implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i < 20; i++) {
                System.out.println("正在听歌" + i);
            }
        }
    }

    public static void main(String[] args) {
        new Thread(new Test()).start();
        new Thread(() -> {
            for (int i = 0; i < 20; i++) {
                System.out.println("正在coding..." + i);
            }
        }).start();
    }
}
