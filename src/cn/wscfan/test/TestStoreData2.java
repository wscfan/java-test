package cn.wscfan.test;

import java.util.*;

public class TestStoreData2 {
    public static void main(String[] args) {
        User user1 = new User(1001, "张三", 2000, "2020.1.1");
        User user2 = new User(1002, "李四", 2000, "2020.1.1");
        User user3 = new User(1003, "王五", 2000, "2020.1.1");
        List<User> list = new ArrayList<>();
        list.add(user1);
        list.add(user2);
        list.add(user3);
        System.out.println(list);
        for(User u: list) {
            System.out.println(u);
        }

        System.out.println("-------------------------");

        Map<Integer, User> map = new HashMap();
        map.put(111, user1);
        map.put(222, user2);
        map.put(333, user3);
        Set<Integer> keyset = map.keySet();
        for(Integer key: keyset) {
            System.out.println(map.get(key));
        }
    }
}

class User {
    private int id;
    private String name;
    private double salary;
    private String hiredate;

    public User() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getHiredate() {
        return hiredate;
    }

    public void setHiredate(String hiredate) {
        this.hiredate = hiredate;
    }

    public User(int id, String name, double salary, String hiredate) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.hiredate = hiredate;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", hiredate='" + hiredate + '\'' +
                '}';
    }
}