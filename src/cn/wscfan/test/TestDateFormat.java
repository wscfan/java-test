package cn.wscfan.test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestDateFormat {
    public static void main(String[] args) throws ParseException {
        DateFormat d1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String str = d1.format(new Date());
        System.out.println(str);
        Date date = d1.parse("2019-12-25 00:15:30");
        System.out.println(date);
    }
}
