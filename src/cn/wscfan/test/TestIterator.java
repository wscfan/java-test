package cn.wscfan.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TestIterator {
    public static void main(String[] args) {
        List<String> list1 = new ArrayList<>();
        list1.add("aaa");
        list1.add("bbb");
        list1.add("ccc");

        for(Iterator<String> iter = list1.iterator(); iter.hasNext();) {
            String temp = iter.next();
            System.out.println(temp);
        }
    }
}
