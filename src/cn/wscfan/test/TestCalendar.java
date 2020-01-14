package cn.wscfan.test;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class TestCalendar {
    public static void main(String[] args) {
        Calendar calendar = new GregorianCalendar(2099, 5, 10);
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DATE);
        int dayWeek = calendar.get(Calendar.DAY_OF_WEEK);
        System.out.println(calendar);
        System.out.println(year);
        System.out.println(month);
        System.out.println(day);
        System.out.println(dayWeek);
        Calendar c2 = new GregorianCalendar();
        System.out.println(c2.get(Calendar.YEAR));
        c2.set(Calendar.YEAR, 2020);
        System.out.println(c2.get(Calendar.YEAR));
    }
}
