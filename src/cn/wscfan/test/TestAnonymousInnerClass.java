package cn.wscfan.test;

public class TestAnonymousInnerClass {
    public static void test01(AA a) {
        a.aa();
    }

    public static void main(String[] args) {
        TestAnonymousInnerClass.test01(new AA() {
            @Override
            public void aa() {
                System.out.println("匿名内部类测试~~~");
            }
        });
    }
}

interface AA {
    void aa();
}