package com.wscfan.oo4;

import com.wscfan.oo3.Human;

public class Child {
    public static void main(String[] args) {
        NewChild people1 = new NewChild();
        people1.sayName();
    }
}

class NewChild extends Human {
    void sayName() {
        name = "张三";
        System.out.println(name);
        System.out.println(height);
    }
}
