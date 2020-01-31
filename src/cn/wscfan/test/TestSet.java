package cn.wscfan.test;

import java.util.HashSet;
import java.util.Set;

public class TestSet {
    public static void main(String[] args) {
        Set<String> s1 = new HashSet<>();
        s1.add("aaa");
        s1.add("bbb");
        System.out.println(s1);
        s1.remove("aaa");
        System.out.println(s1);
        Set<String> n2 = new HashSet<>();
        n2.add("123");
        System.out.println(n2);
        s1.addAll(n2);
        System.out.println(s1);
    }
}
