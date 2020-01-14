package cn.wscfan.test;

public class TestStringBuilder {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 26; i++) {
            char temp = (char)('a' + i);
            sb.append(temp);
        }
        System.out.println(sb);
        sb.reverse();
        System.out.println(sb);
        sb.setCharAt(2, '王');
        System.out.println(sb);
        sb.insert(0, '天');
        System.out.println(sb);
        sb.delete(0, 3);
        System.out.println(sb);
    }
}
