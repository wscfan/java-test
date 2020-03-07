package cn.wscfan.thread;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * @Author 王松
 * @Date 2020/3/7 22:31
 */
public class WebDownloader {
    public void download (String url, String name) {
        try {
            FileUtils.copyURLToFile(new URL(url), new File(name));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("图片下载失败");
        }
    }
}
