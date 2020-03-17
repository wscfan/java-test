package cn.wscfan.syn;

/**
 * @Author 王松
 * @Date 2020/3/17 23:38
 */
public class SynTest02 {
    public static void main(String[] args) {
        SynAccount account = new SynAccount(120, "结婚礼金");
        SynDrawing d1 = new SynDrawing(account, 80, "悲惨的我");
        SynDrawing d2 = new SynDrawing(account, 70, "幸福的她");
        d1.start();
        d2.start();
    }
}

// 账户
class SynAccount {
    int money;
    String name;

    public SynAccount(int money, String name) {
        this.money = money;
        this.name = name;
    }
}

// 模拟取款
class SynDrawing extends Thread {
    SynAccount account;
    int drawingMoney;
    int drawingTotal;

    public SynDrawing(SynAccount account, int drawingMoney, String name) {
        super(name);
        this.account = account;
        this.drawingMoney = drawingMoney;
    }

    @Override
    public void run() {
        test();
    }
    public void test() {
        synchronized(account) {
            if (account.money - drawingMoney <= 0) {
                return;
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            account.money -= drawingMoney;
            drawingTotal += drawingMoney;
            System.out.println(this.getName() + "----> 账户余额：" + account.money);
            System.out.println(this.getName() + "----> 钱包：" + drawingTotal);
        }
    }
}