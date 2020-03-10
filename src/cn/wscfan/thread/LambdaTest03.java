package cn.wscfan.thread;

/**
 * @Author 王松
 * @Date 2020/3/10 22:53
 */
public class LambdaTest03 {
    public static void main(String[] args) {
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println(i);
            }
            System.out.println("正在学习。。。。");
        }).start();
        new Thread(() -> System.out.println("正在工作")).start();
    }
}
