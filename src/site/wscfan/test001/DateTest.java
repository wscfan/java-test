package site.wscfan.test001;


import java.time.LocalDate;
import java.util.Date;

/**
 * @Author 王松
 * @Date 2020/8/2 17:57
 */
public class DateTest {
    public static void main(String[] args) {
        Date date = new Date();
        System.out.println(date.toString());
        System.out.println(LocalDate.now());
        LocalDate myDate = LocalDate.of(1999, 12, 31);
        int year = myDate.getYear();
        int month = myDate.getMonthValue();
        int day = myDate.getDayOfMonth();
        System.out.println(year + "/" + month + "/" + day);
        LocalDate aThousandDaysLater = myDate.plusDays(1000);
        System.out.println(aThousandDaysLater);
    }
}
