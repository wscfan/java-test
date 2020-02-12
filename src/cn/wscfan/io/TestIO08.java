package cn.wscfan.io;

import java.io.ByteArrayOutputStream;

public class TestIO08 {
    public static void main(String[] args) {
        // 1、创建源
        byte[] dest = null;
        // 2、选择流
        ByteArrayOutputStream baos = null;
        try {
            baos = new ByteArrayOutputStream();
            // 3、操作
            String msg = "show me the code.";
            byte[] datas = msg.getBytes();
            baos.write(datas, 0, datas.length);
            baos.flush();
            // 获取数据
            dest = baos.toByteArray();
            System.out.println(new String(dest, 0, dest.length));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
