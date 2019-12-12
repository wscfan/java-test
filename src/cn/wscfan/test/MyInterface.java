package cn.wscfan.test;

public class MyInterface {
    public static void main(String[] args) {
        Bird bird1 = new Bird();
        bird1.fly();
        bird1.sing();
    }
}

interface Fly {
    String FLAY_ACTION = "尽情飞翔~";
    void fly();
}

interface Sing {
    String SING_ACTION = "尽情歌唱";
    void sing();
}

class Bird implements Fly, Sing {

    @Override
    public void fly() {
        System.out.println(FLAY_ACTION);
    }

    @Override
    public void sing() {
        System.out.println(SING_ACTION);
    }
}
