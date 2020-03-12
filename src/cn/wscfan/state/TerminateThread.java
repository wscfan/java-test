package cn.wscfan.state;

/**
 * @Author 王松
 * @Date 2020/3/12 20:20
 */
public class TerminateThread implements Runnable {
    private boolean flag = true;
    private String name;

    public TerminateThread(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        int i = 0;
        while (flag) {
            System.out.println(name + "-->" + i++);
        }
    }

    public void terminate() {
        this.flag = false;
    }

    public static void main(String[] args) {
        TerminateThread tt = new TerminateThread("C罗");
        new Thread(tt).start();

        for (int i = 0; i < 100; i++) {
            if (i == 88) {
                tt.terminate();
                System.out.println("tt game over");
            }
            System.out.println("main-->" + i);
            
        }
    }
}
