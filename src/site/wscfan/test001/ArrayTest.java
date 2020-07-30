package site.wscfan.test001;

import java.util.Arrays;

/**
 * @Author 王松
 * @Date 2020/7/30 22:14
 */
public class ArrayTest {
    public static void main(String[] args) {
        int[] aa = {12, 34, 434};
        System.out.println(Arrays.toString(aa));
        for (int i: aa)
            System.out.println(i);
        int[] bb = Arrays.copyOf(aa, 2);
        System.out.println(Arrays.toString(bb));
        String[][] cc = {
                {"a", "b", "c"},
                {"d", "e", "f"}
        };
        for (String[] row: cc)
            for (String value: row)
                System.out.println(value);
        System.out.println(Arrays.deepToString(cc));
    }
}
