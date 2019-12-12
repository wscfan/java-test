package cn.wscfan.test;

public class TestStaticInnerClass {
    public static void main(String[] args) {
        Outer2.Inner2 inner2 = new Outer2.Inner2();
        inner2.printStr();
    }
}

class Outer2 {
    static class Inner2 {
        void printStr() {
            System.out.println("打印内容~~~");
        }
    }
}
