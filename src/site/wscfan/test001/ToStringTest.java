package site.wscfan.test001;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @Author ws
 * @Date 2020/9/15 23:36
 */
public class ToStringTest {
    public static void main(String[] args) {
        int[] i = {1, 2, 3, 4};
        System.out.println(i.length);
        System.out.println(i);
        System.out.println(Arrays.toString(i));
        ArrayList<Integer> staff = new ArrayList<>();
        staff.add(12);
        staff.add(23);
        staff.add(34);
        System.out.println(staff.size());

    }
}
