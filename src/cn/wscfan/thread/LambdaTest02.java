package cn.wscfan.thread;

/**
 * @Author 王松
 * @Date 2020/3/10 22:11
 */
public class LambdaTest02 {
    static class Love3 implements ILove {

        @Override
        public void lambda(int a) {
            System.out.println("Love" + a);
        }
    }
    public static void main(String[] args) {
        ILove love = (int a) -> {
            System.out.println("Love" + a);
        };
        love.lambda(100);

        ILove love2 = new Love();
        love2.lambda(200);

        new Love3().lambda(300);

        class Love4 implements ILove {

            @Override
            public void lambda(int a) {
                System.out.println("Love" + a);
            }
        }
        new Love4().lambda(400);

        new ILove() {

            @Override
            public void lambda(int a) {
                System.out.println("Love" + a);
            }
        }.lambda(500);

        ILove love6 = a -> {
            System.out.println("Love" + a);
        };
        love6.lambda(600);

        ILove love7 = a -> System.out.println("Love" + a);
        love7.lambda(700);
    }
}

interface ILove {
    void lambda(int a);
}
// 外部类
class Love implements ILove {

    @Override
    public void lambda(int a) {
        System.out.println("Love" + a);
    }
}