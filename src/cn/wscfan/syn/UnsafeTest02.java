package cn.wscfan.syn;

/**
 * @Author 王松
 * @Date 2020/3/16 20:39
 */
public class UnsafeTest02 {
    public static void main(String[] args) {
        Account account = new Account(100, "结婚礼金");
        Drawing d1 = new Drawing(account, 80, "悲惨的我");
        Drawing d2 = new Drawing(account, 70, "幸福的她");
        d1.start();
        d2.start();
    }
}

// 账户
class Account {
    int money;
    String name;

    public Account(int money, String name) {
        this.money = money;
        this.name = name;
    }
}

// 模拟取款
class Drawing extends Thread {
    Account account;
    int drawingMoney;
    int drawingTotal;

    public Drawing(Account account, int drawingMoney, String name) {
        super(name);
        this.account = account;
        this.drawingMoney = drawingMoney;
    }

    @Override
    public void run() {
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
