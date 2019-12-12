package cn.wscfan.test;

public class TestInnerClass {
    public static void main(String[] args) {
        Outer.Inner inner1 = new Outer().new Inner();
        inner1.printName();
    }
}

class Outer {
    private String name = "小明";
    class Inner {
        void printName() {
            System.out.println("姓名是：" + Outer.this.name);
        }
    }
}
