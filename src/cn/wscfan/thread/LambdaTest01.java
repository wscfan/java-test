package cn.wscfan.thread;

/**
 * @Author 王松
 * @Date 2020/3/10 21:48
 */
public class LambdaTest01 {
   static class Like2 implements ILike {
        @Override
        public void lambda() {
            System.out.println("I like lambda2");
        }
    }

    public static void main(String[] args) {
        ILike like = new Like();
        like.lambda();
        ILike like2 = new Like2();
        like2.lambda();
        new ILike() {
            @Override
            public void lambda() {
                System.out.println("I like lambda3");
            }
        }.lambda();
        ILike like4 = () -> {
            System.out.println("I like lambda4");
        };
        like4.lambda();

        class Like5 implements ILike {

            @Override
            public void lambda() {
                System.out.println("I like lambda5");
            }
        }

        ILike like5 = new Like5();
        like5.lambda();
    }
}

interface ILike {
    void lambda();
}
class Like implements ILike {
    @Override
    public void lambda() {
        System.out.println("I like lambda");
    }
}
