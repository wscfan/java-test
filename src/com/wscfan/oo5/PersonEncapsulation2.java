package com.wscfan.oo5;
import cn.wscfan.test.PersonEncapsulation;

public class PersonEncapsulation2 {
    public static void main(String[] args) {
        PersonEncapsulation p1 = new PersonEncapsulation();
        p1.setName("张三");
        p1.setAge(99);
        System.out.println(p1.getName());
        System.out.println(p1.getAge());
    }
}
