package cn.wscfan.test;

public class PersonEncapsulation {
    private int id;
    private String name;
    private int age;
    private Boolean man;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return this.name;
    }
    public void setAge(int age) {
        if (age >= 1 && age <= 130) {
            this.age = age;
        } else {
            System.out.println("请输入正确的年龄~");
        }
    }
    public int getAge() {
        return this.age;
    }
}
