package com.wscfan.oo2;

public class TestExtends {
    public static void main(String[] args) {
        Student p1 = new Student();
        p1.rest();
        p1.study();
        Student p2 = new Student("张三", 180, 19);
        System.out.printf("姓名：%s，身高：%d，年龄：%d", p2.name, p2.height, p2.age);
    }
}

class Person {
    String name;
    int height;
    int age;
    public void rest() {
        System.out.println("休息一会儿~~~");
    }
}

class Student extends Person {
    public void study() {
        System.out.println("学习一会儿~~~");
    }
    public Student(String name, int height, int age) {
        this.name = name;
        this.height = height;
        this.age = age;
    }
    public Student() {

    }
}
