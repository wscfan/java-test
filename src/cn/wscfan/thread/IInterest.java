package cn.wscfan.thread;

/**
 * @Author 王松
 * @Date 2020/3/10 22:42
 */
public class IInterest {
    public static void main(String[] args) {
        IPlus total = (a, b) -> a + b;
        System.out.println(total.plus(30, 40));
    }
}
interface IPlus {
    int plus(int a, int b);
}