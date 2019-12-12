package cn.wscfan.test;

public class TestPolym {
    public static void main(String[] args) {
        Dog d1 = new Dog();
        AnimalCry(d1);
        d1.run();
        Animal c1 = new Cat();
        AnimalCry(c1);
        Cat c2 = (Cat)c1;
        c2.zhua();
    }
    static void AnimalCry(Animal a) {
        a.cry();
    }
}

class Animal {
    void cry() {
        System.out.println("。。。。。。");
    }
}

class Dog extends Animal {
    void cry() {
        System.out.println("wwwwwww");
    }
    void run() {
        System.out.println("rrrrrrrrrr");
    }
}

class Cat extends Animal {
    void cry() {
        System.out.println("mmmmmmm");
    }
    void zhua() {
        System.out.println("zzzzzzzzzzzz");
    }
}
