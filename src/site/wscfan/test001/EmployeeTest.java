package site.wscfan.test001;

import java.time.*;
import java.util.Objects;

/**
 * @Author 王松
 * @Date 2020/8/2 22:20
 */
public class EmployeeTest {
    public static void main(String[] args) {
        Employee[] staff = new Employee[3];

        staff[0] = new Employee("Carl", 7500, 1990, 6, 3);
        staff[1] = new Employee("Harry", 5000, 1991, 9, 12);
        staff[2] = new Employee("petty", 4000, 1992, 12, 12);

        for (Employee e : staff)
            e.raiseSalary(5);

        for (Employee e: staff)
            System.out.println("name=" + e.getName() + ",Salary=" + e.getSalary() + ",hireDay=" + e.getHireDay());
    }
}

class Employee {
    private String name;
    private double salary;
    private LocalDate hireDay;

    public Employee(String n, double s, int year, int month, int day) {
        Objects.requireNonNull(n, "姓名不能为空");
        name = n;
//        name = Objects.requireNonNullElse(n, "unknown");
        salary = s;
        hireDay = LocalDate.of(year, month, day);
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public LocalDate getHireDay() {
        return hireDay;
    }

    public void raiseSalary(double byPercent) {
        double raise = salary * byPercent / 100;
        salary += raise;
    }
}
