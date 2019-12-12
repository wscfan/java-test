package cn.wscfan.test;

public abstract class AbstractTest {
    public static void main(String[] args) {
        Student s1 = new Student();
        s1.name = "张三";
        s1.eat();
    }
}

abstract class Person {
    String name;
    abstract void eat();
}

class Student extends Person {
    void eat() {
        System.out.println(name + "完成了");
    }
}
