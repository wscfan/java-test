package cn.wscfan.cooperation;

/**
 * @Author 王松
 * @Date 2020/3/21 12:27
 */
public class CoTest01 {
    public static void main(String[] args) {
        SynContainer container = new SynContainer();
        new Productor(container).start();
        new Consumer(container).start();
    }
}

// 生产者
class Productor extends Thread {
    SynContainer container;

    public Productor(SynContainer container) {
        this.container = container;
    }

    @Override
    public void run() {
        // 生产
        for (int i = 0; i < 100; i++) {
            System.out.println("生产--->" + i + "个馒头");
            container.push(new Steamedbun(i));
        }
    }
}

// 消费者
class Consumer extends Thread {
    SynContainer container;

    public Consumer(SynContainer container) {
        this.container = container;
    }

    @Override
    public void run() {
        // 消费
        for (int i = 0; i < 100; i++) {
            System.out.println("消费-------->" + container.pop().id + "个馒头");
        }
    }
}

// 缓冲区
class SynContainer {
    Steamedbun[] buns = new Steamedbun[10]; // 存储容器
    int count = 0;

    // 存取
    public synchronized void push(Steamedbun bun) {
        // 不能生产
        if (count == buns.length) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // 存在空间，可以生产
        buns[count] = bun;
        count++;
        this.notifyAll(); // 存在空间，可以消费
    }

    // 获取
    public synchronized Steamedbun pop() {
        // 没有数据，等待
        if (count == 0) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        count--;
        Steamedbun bun = buns[count];
        this.notifyAll(); // 存在空间，可以生产
        return bun;
    }

}

// 馒头
class Steamedbun {
    int id;

    public Steamedbun(int id) {
        this.id = id;
    }
}
