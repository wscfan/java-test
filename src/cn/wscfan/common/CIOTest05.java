package cn.wscfan.common;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * @Author 王松
 * @Date 2020/2/16 20:51
 */
public class CIOTest05 {
    public static void main(String[] args) throws IOException {
        File src = new File("src/cn/wscfan/common/data/test.txt");
        File dest = new File("src/cn/wscfan/common/data/test-copy.txt");
        FileUtils.copyFile(src, dest);
        FileUtils.copyFileToDirectory(src, new File("src/cn/wscfan/common/data/dir"));
//        FileUtils.copyDirectoryToDirectory(new File("src/cn/wscfan/common/data/dir"), new File("src/cn/wscfan/common/data/dir"));
        String url = "https://imgcdn.toutiaoyule.com/20200202/816994014ee289fcdde269df1f58b52d.jpg";
        FileUtils.copyURLToFile(new URL(url), new File("src/cn/wscfan/common/data/img/test.jpg"));
//        String data = IOUtils.toString(new URL("http://www.baidu.com/"), "UTF-8");
//        System.out.println(data);
    }
}
