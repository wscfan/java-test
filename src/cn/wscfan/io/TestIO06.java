package cn.wscfan.io;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class TestIO06 {
    public static void main(String[] args) {
        // 1、创建源
        File dest = new File("src/cn/wscfan/io/data/writer.txt");
        // 2、选择流
        Writer writer = null;
        try {
            writer = new FileWriter(dest);
            // 3、操作
            String msg = new String("锄禾日当午\r\n汗滴禾下土。");
            // 写法一
/*            char[] datas = msg.toCharArray();
            writer.write(datas, 0, datas.length);*/
            // 写法二
/*            writer.write(msg);*/
            // 写法三
            writer.append("今天天气很好\r\n").append("我们一起去玩耍。");
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 4、释放资源
            try {
                if (null != writer) {
                    writer.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
