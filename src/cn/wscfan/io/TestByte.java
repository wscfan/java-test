package cn.wscfan.io;

import java.io.UnsupportedEncodingException;

public class TestByte {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String str = "今天天气真好";
        byte[] msg = str.getBytes();
        System.out.println(msg.length);
        String str2 = new String(msg, 3, 3, "utf-8");
        System.out.println(str2);
    }
}
