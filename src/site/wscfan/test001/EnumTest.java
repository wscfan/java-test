package site.wscfan.test001;

import java.util.Scanner;

/**
 * @Author ws
 * @Date 2020/9/24 22:45
 */
public class EnumTest {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter a size:(SMALL, MEDIUM, LARGE, EXTRA_LARGE");
        String input = in.next().toUpperCase();
        Size size = Enum.valueOf(Size.class, input);
        System.out.println("size=" + size);
        System.out.println("abbreviation=" + size.getAbbreviation());
        System.out.println(size.toString());
        System.out.println(size.ordinal());
        System.out.println(Size.class);
        Size size2 = Enum.valueOf(Size.class, "MEDIUM");
        System.out.println(size.compareTo(size2));
    }
}

enum Size {
    SMALL("S"), MEDIUM("M"), LARGE("L"), EXTRA_LARGE("XL");
    private final String abbreviation;

    private Size(String abbreviation) {
        this.abbreviation = abbreviation;
    }
    public String getAbbreviation() {
        return abbreviation;
    }
}
