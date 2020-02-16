package cn.wscfan.common;


import org.apache.commons.io.FileUtils;

import java.io.File;

/**
 * @Author 王松
 * @Date 2020/2/16 20:00
 */
public class CIOTest01 {
    public static void main(String[] args) {
        long len = FileUtils.sizeOf(new File("src/cn/wscfan/common/CIOTest01.java"));
        System.out.println(len);
        len = FileUtils.sizeOf(new File("C:/mycode/java-test"));
        System.out.println(len);
    }
}
