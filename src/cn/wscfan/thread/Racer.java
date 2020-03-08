package cn.wscfan.thread;

/**
 * @Author 王松
 * @Date 2020/3/8 10:59
 */
public class Racer implements Runnable {
    private String winner;
    @Override
    public void run() {
        for (int step = 1; step <= 100; step++) {
            if (Thread.currentThread().getName().equals("兔子") && step % 10 == 0) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName() + "走了" + step + "步");
            boolean flag = gameOver(step);
            if (flag) {
                break;
            }
        }
    }
    private boolean gameOver(int steps) {
        if (winner != null) {
            return true;
        } else {
            if (steps == 100) {
                winner = Thread.currentThread().getName();
                System.out.println("胜利者是：" + winner);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Racer racer = new Racer();
        new Thread(racer, "乌龟").start();
        new Thread(racer, "兔子").start();
    }
}
