package cn.wscfan.test;

public class TestString2 {
    public static void main(String[] args) {
        String[] s1 = {"aaa", "bbb", "ccc", "ddd", "eee", "fff", "ggg"};
 /*       String[] s2 = new String[10];
        System.arraycopy(s1, 0, s2, 3, 2);
        for (int i = 0; i < s2.length; i++) {
            System.out.println(s2[i]);
        }*/
        removeElement(s1, 2);
    }

    public static String[] removeElement(String[] s, int index) {
        System.arraycopy(s, index + 1, s, index, s.length - 1 - index);
        s[s.length - 1] = null;
        for (int i = 0; i < s.length; i++) {
            System.out.println(s[i]);
        }
        return s;
    }
}
