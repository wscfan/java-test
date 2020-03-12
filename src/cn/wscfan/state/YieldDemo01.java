package cn.wscfan.state;

/**
 * @Author 王松
 * @Date 2020/3/12 22:43
 */
public class YieldDemo01 {
    public static void main(String[] args) {
        MyYield my = new MyYield();
        new Thread(my, "tr1").start();
        new Thread(my, "tr2").start();
    }
}

class MyYield implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "-->start");
        Thread.yield();
        System.out.println(Thread.currentThread().getName() + "-->end");
    }
}