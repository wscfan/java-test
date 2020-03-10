package cn.wscfan.thread;

/**
 * @Author 王松
 * @Date 2020/3/10 20:19
 */
public class StaticProxy {
    public static void main(String[] args) {
        new WeddingCompany(new You()).happyMary();
    }
}

interface Marry {
    void happyMary();
}
// 真实角色
class You implements Marry {

    @Override
    public void happyMary() {
        System.out.println("终于结婚了...");
    }
}
// 代理角色
class WeddingCompany implements Marry {
    // 真实角色
    private Marry target;

    WeddingCompany(Marry target) {
        this.target = target;
    }

    @Override
    public void happyMary() {
        ready();
        this.target.happyMary();
        after();
    }

    private void ready() {
        System.out.println("开始准备");
    }

    private void after() {
        System.out.println("已经结束");
    }
}