package com.wscfan.oo2;

public class TestEncapsulation {
    public static void main(String[] args) {
        Human human1 = new Human();
        human1.age = 19;
        human1.sayAge();

        Child child1 = new Child();
        child1.sayHello();

        Person per1 = new Person();
        per1.rest();
    }
}

class Human {
    int age;
    void sayAge() {
        System.out.println(age);
    }
}

class Child extends Human {
    void sayHello() {
        age = 99;
        System.out.println(age);
    }
}
