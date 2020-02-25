package cn.wscfan.thread;

/**
 * @Author 王松
 * @Date 2020/2/25 22:36
 */
public class StartThread extends Thread {
    /**
     * 线程入口点
     */
    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println("一边听歌一遍上网");
        }
    }

    public static void main(String[] args) {
        // 创建子类对象
        StartThread st = new StartThread();
        // 启动
        st.start();
        for (int i = 0; i < 20; i++) {
            System.out.println("一边听歌一边写代码");
        }
    }
}
