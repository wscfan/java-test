package com.wscfan.oo2;

public class TestOverride {
    public static void main(String[] args) {
        Horse hor1 = new Horse();
        hor1.run();
    }
}

class Animal {
    public void run() {
        System.out.println("跑。。。。。");
    }
}

class Horse extends Animal {
    public void run() {
        System.out.println("跑，得得得。。。");
    }
}