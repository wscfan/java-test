package cn.wscfan.test;

public class TestAutoBox {
    public static void main(String[] args) {
        Integer in3 = 1234;
        Integer in4 = 1234;
        System.out.println(in3 == in4);
        System.out.println(in3.equals(in4));
    }
}
