package cn.wscfan.test;

import java.util.ArrayList;
import java.util.Collection;

public class TestList {
    public static void main(String[] args) {
        Collection<String> c = new ArrayList<>();
        System.out.println(c.size());
        c.add("张三");
        System.out.println(c);
        c.add("李四");
        System.out.println(c);
        Object[] obj = c.toArray();
        System.out.println(obj);
        c.clear();
        System.out.println(c);
    }
}
