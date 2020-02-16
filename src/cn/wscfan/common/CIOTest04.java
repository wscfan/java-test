package cn.wscfan.common;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author 王松
 * @Date 2020/2/16 20:34
 */
public class CIOTest04 {
    public static void main(String[] args) throws IOException {
        FileUtils.write(new File("src/cn/wscfan/common/data/test.txt"), "Hello World\r\n", "UTF-8", true);
        FileUtils.writeStringToFile(new File("src/cn/wscfan/common/data/test.txt"), "每天学习一点点\r\n", "UTF-8", true);
        FileUtils.writeByteArrayToFile(new File("src/cn/wscfan/common/data/test.txt"), "好好学习\r\n".getBytes(), true);
        List<String> data = new ArrayList<>();
        data.add("第一");
        data.add("第二");
        data.add("第三");
        FileUtils.writeLines(new File("src/cn/wscfan/common/data/test.txt"), data, "----", true);
    }
}
