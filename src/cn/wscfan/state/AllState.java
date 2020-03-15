package cn.wscfan.state;

/**
 * @Author 王松
 * @Date 2020/3/15 11:36
 */
public class AllState {
    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(".....");
        });
        Thread.State state = t.getState();
        System.out.println(state);
        t.start();
        state = t.getState();
        System.out.println(state);
        while (true) {
            int num = Thread.activeCount();
            if (num == 2) {
                break;
            }
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            state = t.getState();
            System.out.println(state);
        }
    }
}
